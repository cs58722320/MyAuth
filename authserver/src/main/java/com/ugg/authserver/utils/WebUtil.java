/**
 * Copyright (C), 2015-2019
 * FileName: WebUtil
 * Author:   qhong
 * Date:     2019/7/3 17:26
 * Description: 处理各种请求信息工具类
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理各种请求信息工具类<br> 
 *
 * @author qhong
 * @create 2019/7/3
 * @since 1.0.0
 */
public class WebUtil {

    /**
     * 获取当前请求的ip地址
     * @return
     */
    public static final String acquireRequestIp(){
        HttpServletRequest request = getCurrentRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取当前请求对象
     * @return
     */
    public static final HttpServletRequest getCurrentRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (requestAttributes == null) ? null : ((ServletRequestAttributes) requestAttributes).getRequest();
    }

}