/**
 * Copyright (C), 2015-2019
 * FileName: Md5Handler
 * Author:   DUJE003
 * Date:     2019/6/6 23:46
 * Description: MD5加密操作类
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * MD5加密操作类<br> 
 *
 * @author DUJE003
 * @create 2019/6/6
 * @since 1.0.0
 */
public class Md5Handler {

    /**
     * 将字符串转换为md5（32位小文字）
     * @param password
     * @return
     */
    public static String convertMd5Small32(String password){
        if(StringUtils.isEmpty(password)){
            return null;
        }

        //加密后的字符串
        String encodeStr= DigestUtils.md5DigestAsHex(password.getBytes());
        return encodeStr;
    }
}