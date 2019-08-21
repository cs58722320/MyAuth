/**
 * Copyright (C), 2015-2019
 * FileName: UserRoleServiceImpl
 * Author:   DUJE003
 * Date:     2019/6/10 14:35
 * Description: 用户角色服务实现
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.service.impl;

import com.ugg.authserver.entity.CrmSysAuth;
import com.ugg.authserver.entity.CrmSysAuthExample;
import com.ugg.authserver.entity.CrmSysUserRole;
import com.ugg.authserver.entity.CrmSysUserRoleExample;
import com.ugg.authserver.mapper.CrmSysAuthMapper;
import com.ugg.authserver.mapper.CrmSysUserRoleMapper;
import com.ugg.authserver.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户角色服务实现<br> 
 *
 * @author DUJE003
 * @create 2019/6/10
 * @since 1.0.0
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    CrmSysAuthMapper crmSysAuthMapper;

    @Override
    public Map<Integer, List<CrmSysAuth>> getAuthMap() {
        CrmSysAuthExample condition = new CrmSysAuthExample();
        condition.createCriteria().andIsDeletedEqualTo(false);
        List<CrmSysAuth> resultList = crmSysAuthMapper.selectByExample(condition);
        Map<Integer, List<CrmSysAuth>> result = resultList.stream().collect(Collectors.groupingBy(CrmSysAuth::getRoleId));
        return result;
    }
}