package com.ugg.authserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ugg.authserver.controller", "com.ugg.authserver.service", "com.ugg.authserver.config", "com.ugg.authserver.runner"})
@MapperScan(basePackages = {"com.ugg.authserver.mapper"})
public class AuthServerApplication {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AuthServerApplication.class);
		applicationContext = app.run(args);
	}

	public static ApplicationContext getAppContext(){
		return applicationContext;
	}

}