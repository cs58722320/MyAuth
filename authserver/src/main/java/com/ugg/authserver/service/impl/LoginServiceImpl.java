/**
 * Copyright (C), 2015-2019
 * FileName: LoginServiceImpl
 * Author:   DUJE003
 * Date:     2019/6/7 23:30
 * Description: 登陆服务实现
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.service.impl;

import com.ugg.authserver.config.TokenProperties;
import com.ugg.authserver.entity.CrmSysAuthLog;
import com.ugg.authserver.entity.CrmSysUser;
import com.ugg.authserver.entity.CrmSysUserRole;
import com.ugg.authserver.entity.CrmSysUserRoleExample;
import com.ugg.authserver.mapper.CrmSysAuthLogMapper;
import com.ugg.authserver.mapper.CrmSysUserRoleMapper;
import com.ugg.authserver.service.LoginService;
import com.ugg.authserver.service.UserService;
import com.ugg.authserver.utils.JWTUtils;
import com.ugg.authserver.utils.Md5Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 登陆服务实现<br> 
 *
 * @author DUJE003
 * @create 2019/6/7
 * @since 1.0.0
 */
@Service
public final class LoginServiceImpl implements LoginService {

    @Autowired
    UserService userService;

    @Autowired
    CrmSysUserRoleMapper crmSysUserRoleMapper;

    @Autowired
    TokenProperties tokenProperties;

    @Autowired
    CrmSysAuthLogMapper crmSysAuthLogMapper;

    @Override
    public boolean identifyUserInfo(String loginName, String password) {
        CrmSysUser crmSysUser = userService.findSysUserByLoginName(loginName);
        String encodedPassword = Md5Handler.convertMd5Small32(password);
        if(crmSysUser.getLoginPassword().equals(encodedPassword)){
            return true;
        }
        return false;
    }

    @Override
    public List<Integer> getUserRole(String loginName) {
        CrmSysUser crmSysUser = userService.findSysUserByLoginName(loginName);
        CrmSysUserRoleExample condition = new CrmSysUserRoleExample();
        condition.createCriteria().andUserIdEqualTo(crmSysUser.getId()).andIsDeletedEqualTo(false);
        List<CrmSysUserRole> userRoles = crmSysUserRoleMapper.selectByExample(condition);
        List<Integer> roleIds = userRoles.parallelStream().map(a -> a.getRoleId()).collect(Collectors.toList());
        return roleIds;

    }

    @Override
    public String generateToken(Map<String, Object> payload) {
        try {
            String jwtToken = JWTUtils.createJWT("jeff", "login", tokenProperties.getExpirePeriod()*1000*60, payload);
            return jwtToken;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void loginRecord(String userName, String ipAddr) {
        CrmSysAuthLog crmSysAuthLog = new CrmSysAuthLog();
        crmSysAuthLog.setUserName(userName);
        crmSysAuthLog.setIpAddr(ipAddr);
        crmSysAuthLog.setCreateTime(new Date());
        crmSysAuthLogMapper.insert(crmSysAuthLog);
    }
}