/**
 * Copyright (C), 2015-2019
 * FileName: TestController
 * Author:   DUJE003
 * Date:     2019/6/6 14:35
 * Description: 测试用控制层
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.controller;

import com.ugg.authserver.entity.CrmMemberGift;
import com.ugg.authserver.entity.CrmMemberGiftExample;
import com.ugg.authserver.mapper.CrmMemberGiftMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * 〈测试用控制层〉<br>
 *
 * @author DUJE003
 * @create 2019/6/6
 * @since 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    CrmMemberGiftMapper mapper;

    @Autowired
    HikariDataSource hikariDataSource;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (requestAttributes == null) ? null : ((ServletRequestAttributes) requestAttributes).getRequest();
        final String[] values = {null};
        request.getParameterMap().entrySet().stream().forEach(a -> {
            values[0] += a.getKey() + a.getValue() + ", ";
        });
        return values[0];
    }

    @RequestMapping(path = "/test1", method = RequestMethod.GET)
    public String test1(){
        redisTemplate.opsForValue().set("123", "123");
        return null;
    }
}