/**
 * Copyright (C), 2015-2019
 * FileName: TokenProperties
 * Author:   DUJE003
 * Date:     2019/6/8 0:34
 * Description: Token参数配置
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Token参数配置<br> 
 *
 * @author DUJE003
 * @create 2019/6/8
 * @since 1.0.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "token")
public class TokenProperties {
    /**
     * jwtToken过期时间（s）
     */
    long expirePeriod;
    /**
     * 使用加密算法
     */
    String algorithm;
}