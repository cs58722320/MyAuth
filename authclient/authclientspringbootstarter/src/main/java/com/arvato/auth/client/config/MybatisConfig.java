/**
 * Copyright (C), 2015-2019
 * FileName: MybatisConfig
 * Author:   qhong
 * Date:     2019/6/24 9:50
 * Description: 扫包
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.arvato.auth.client.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 扫包<br> 
 *
 * @author qhong
 * @create 2019/6/24
 * @since 1.0.0
 */
@Configuration
public class MybatisConfig {

    @Bean
    MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.arvato.auth.client.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }

}