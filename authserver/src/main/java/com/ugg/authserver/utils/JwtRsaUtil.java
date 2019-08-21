/**
 * Copyright (C), 2015-2019
 * FileName: JwtRsaUtil
 * Author:   DUJE003
 * Date:     2019/6/10 10:18
 * Description: 生成RSA证书工具类
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.utils;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPublicKeySpec;

/**
 * 生成RSA证书工具类<br> 
 *
 * @author DUJE003
 * @create 2019/6/10
 * @since 1.0.0
 */
public class JwtRsaUtil {
    private String keyStoreFile;
    private char[] password;
    private KeyStore store;
    private Object lock = new Object();

    private static JwtRsaUtil instance = null;

    public static JwtRsaUtil getInstance() {
        synchronized (JwtRsaUtil.class) {
            if (instance == null) {
                synchronized (JwtRsaUtil.class) {
                    //这里是jks文件路径和密码
                    instance = new JwtRsaUtil("/server.jks", "87654321".toCharArray());
                }
            }
            return instance;
        }
    }

    public JwtRsaUtil(String _jksFilePath, char[] password) {
        this.keyStoreFile = _jksFilePath;
        this.password = password;
    }

    public KeyPair getKeyPair() {
        return getKeyPair("private", this.password);
    }

    public KeyPair getKeyPair(String alias, char[] password) {
        try {
            synchronized (this.lock) {
                if (this.store == null) {
                    synchronized (this.lock) {
                        InputStream is = this.getClass().getResourceAsStream(keyStoreFile);
                        try {
                            this.store = KeyStore.getInstance("JKS");
                            this.store.load(is, this.password);
                        } finally {
                            if (is != null) {
                                try {
                                    is.close();
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                }
            }
            RSAPrivateCrtKey key = (RSAPrivateCrtKey) this.store.getKey(alias, password);
            RSAPublicKeySpec spec = new RSAPublicKeySpec(key.getModulus(), key.getPublicExponent());
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);
            return new KeyPair(publicKey, key);
        } catch (Exception e) {
            throw new IllegalStateException("装在不了该Key: " + this.keyStoreFile, e);
        }
    }
}