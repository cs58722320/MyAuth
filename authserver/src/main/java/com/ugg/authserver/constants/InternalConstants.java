/**
 * Copyright (C), 2015-2019
 * FileName: InternalConstants
 * Author:   DUJE003
 * Date:     2019/6/6 23:58
 * Description: 内部常量
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.constants;

/**
 * 内部常量<br> 
 *
 * @author DUJE003
 * @create 2019/6/6
 * @since 1.0.0
 */
public final  class InternalConstants {
    /**
     * 返回码：返回成功
     */
    public static String SUCCESS_CODE = "1";
    /**
     * 返回码：返回失败
     */
    public static String ERROR_CODE = "0";

    /**
     * 删除状态：已删除
     */
    public static boolean DELETED = true;
    /**
     * 删除状态：未删除
     */
    public static boolean NOT_DELETED = false;

    /**
     * JWT私有密钥
     */
    public static String JWT_SECRET="7786df7fc3a34e26a61c034d5ec8245d";

    /**
     * JWT过期时间
     */
}