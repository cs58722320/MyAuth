/**
 * Copyright (C), 2015-2019
 * FileName: AuthClientProperties
 * Author:   DUJE003
 * Date:     2019/6/11 14:21
 * Description: 授权客户端配置信息
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.arvato.auth.client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 授权客户端配置信息<br> 
 *
 * @author DUJE003
 * @create 2019/6/11
 * @since 1.0.0
 */
@Data
@ConfigurationProperties(prefix="auth.client")
public class AuthClientProperties {

    /**
     * 不用验证得URL
     */
    private List<String> noAuthUrl;

    /**
     * 超级管理用户账号
     */
    private List<String> adminAccount;

}