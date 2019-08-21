/**
 * Copyright (C), 2015-2019
 * FileName: FilterRegistrationBean
 * Author:   DUJE003
 * Date:     2019/6/10 21:48
 * Description: 注册过滤器
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.arvato.auth.client.config;

import com.arvato.auth.client.filter.DefaultAuthValidateFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 注册过滤器<br> 
 *
 * @author DUJE003
 * @create 2019/6/10
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(AuthClientProperties.class)
public class AuthClientConfig {

    @Autowired
    AuthClientProperties authClientProperties;

    @Bean
    @ConditionalOnMissingBean(DefaultAuthValidateFilter.class)
    public FilterRegistrationBean authClientFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        DefaultAuthValidateFilter defaultAuthValidateFilter = new DefaultAuthValidateFilter();
        defaultAuthValidateFilter.setAuthClientProperties(authClientProperties);
        registration.setFilter(defaultAuthValidateFilter);
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("authValidateFilter");
        registration.setOrder(1);
        return registration;
    }

}