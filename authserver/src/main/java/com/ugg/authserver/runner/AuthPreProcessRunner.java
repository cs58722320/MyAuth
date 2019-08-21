/**
 * Copyright (C), 2015-2019
 * FileName: StartService
 * Author:   DUJE003
 * Date:     2019/6/10 14:27
 * Description: 启动Runner
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.runner;

import com.ugg.authserver.entity.CrmSysAuth;
import com.ugg.authserver.entity.CrmSysUserRole;
import com.ugg.authserver.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 启动Runner<br> 
 * 启动时预热redis角色列表
 * @author DUJE003
 * @create 2019/6/10
 * @since 1.0.0
 */
@Component
@Order(1)
@Slf4j
public class AuthPreProcessRunner implements ApplicationRunner {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserRoleService userRoleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<Integer, List<CrmSysAuth>> authMap = userRoleService.getAuthMap();
        // TODO: 后期优化加入分布式锁
        authMap.entrySet().stream().forEach(a -> {
            redisTemplate.delete(a.getKey());
            a.getValue().parallelStream().forEach(
                    b -> {
                        log.info("RoleID:{}->Path:{}", a.getKey(), b.getAccessPath());
                        redisTemplate.opsForSet().add(a.getKey(), b.getAccessPath());
                    }
            );
        });
    }
}