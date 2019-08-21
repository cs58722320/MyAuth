/**
 * Copyright (C), 2015-2019
 * FileName: JWTUtils
 * Author:   DUJE003
 * Date:     2019/6/7 18:22
 * Description: JWT工具类
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.utils;

import com.ugg.authserver.AuthServerApplication;
import com.ugg.authserver.constants.InternalConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

/**
 * JWT工具类<br> 
 *
 * @author DUJE003
 * @create 2019/6/7
 * @since 1.0.0
 */
public class JWTUtils {
    /**
     * 创建jwt
     * @param id
     * @param subject
     * @param ttlMillis 过期的时间长度
     * @return
     * @throws Exception
     */
    public static String createJWT(String id, String subject, long ttlMillis, Map<String,Object> payLoad
    ) throws Exception {

        String algorithm = AuthServerApplication.getAppContext().getEnvironment().getProperty("token.algorithm");

        //声名SHA384为签名加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.forName(algorithm);
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS384;
        long nowMillis = System.currentTimeMillis();//生成JWT的时间
        Date now = new Date(nowMillis);
        //生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，
        //切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去。
        //一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
        SecretKey key = generalKey();
        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(payLoad)          //如果有私有声明，一定要先设置这个自己创建的私有声明，
                //给builder的claim赋值，一旦写在标准的声明赋值之后，
                //就是覆盖了那些标准的声明的

                .setId(id)                  //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，
                //这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。

                .setIssuedAt(now)           //iat: jwt的签发时间
                .setSubject(subject)        //sub(Subject)：代表这个JWT的主体，即它的所有人，
                //这个是一个json格式的字符串，可以存放什么userid，
                //roldid之类的，作为什么用户的唯一标志。

                .signWith(signatureAlgorithm, key);//设置签名使用的签名算法和签名使用的秘钥
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);     //设置过期时间
        }
        return builder.compact();           //就开始压缩为xxxxxxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxxxxx这样的jwt

    }


    /**
     * 由字符串生成加密key
     * @return
     */
    private static SecretKey generalKey(){
        String stringKey = InternalConstants.JWT_SECRET;//本地配置文件中加密的密文7786df7fc3a34e26a61c034d5ec8245d
        byte[] encodedKey = Base64.getDecoder().decode(stringKey);//本地的密码解码[B@152f6e2
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");// 根据给定的字节数组使用AES加密算法构造一个密钥，使用 encodedKey中的始于且包含 0 到前 leng 个字节这是当然是所有。
        return key;
    }

    /**
     * 解密jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey key = generalKey();  //签名秘钥，和生成的签名的秘钥一模一样
        Claims claims = Jwts.parser()  //得到DefaultJwtParser
                .setSigningKey(key)         //设置签名的秘钥
                .parseClaimsJws(jwt).getBody();//设置需要解析的jwt
        return claims;
    }


//    public static void main(String[] args) throws Exception {
//
//        long starTime=System.currentTimeMillis();
//        for(int i = 0; i < 1000; i++){
//            JWTUtils jwtUtils = new JWTUtils();
//            System.out.println(i);
//            Map<String, Object> payload = new HashMap<String, Object>();
//            Random rand = new Random();
//            System.out.println(rand.nextInt(10000));
//            payload.put("123", rand.nextInt(10000));
//            String jwt = jwtUtils.createJWT("123", "321", 24*1000*60, payload);
//            System.out.println(jwt);
//            Claims claims = jwtUtils.parseJWT(jwt);
//            Integer result = claims.get("123", Integer.class);
//            System.out.println(result);
//        }
//    }
}