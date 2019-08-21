/**
 * Copyright (C), 2015-2019
 * FileName: UserServiceImpl
 * Author:   DUJE003
 * Date:     2019/6/6 17:38
 * Description: 用户操作服务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.service.impl;

import com.ugg.authserver.constants.InternalConstants;
import com.ugg.authserver.controller.authmanagement.vo.UserVo;
import com.ugg.authserver.entity.CrmSysUser;
import com.ugg.authserver.entity.CrmSysUserExample;
import com.ugg.authserver.mapper.CrmSysUserMapper;
import com.ugg.authserver.service.UserService;
import com.ugg.authserver.utils.Md5Handler;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户操作服务实现类<br> 
 *
 * @author DUJE003
 * @create 2019/6/6
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

     @Resource
     CrmSysUserMapper crmSysUserMapper;

     @Override
     public int addSysUser(CrmSysUser user){
         // TODO:
         Date now = new Date();
         user.setCreateTime(now);
         user.setUpdateTime(now);
         user.setIsDeleted(InternalConstants.NOT_DELETED);
         user.setLoginPassword(Md5Handler.convertMd5Small32(user.getLoginPassword()));
         return crmSysUserMapper.insertSelective(user);
     }

    @Override
    public CrmSysUser findSysUserByLoginName(String loginName) {
        CrmSysUserExample example = new CrmSysUserExample();
        example.createCriteria().andLoginNameEqualTo(loginName).andIsDeletedEqualTo(InternalConstants.NOT_DELETED);
        List<CrmSysUser> resultList = crmSysUserMapper.selectByExample(example);
        if(resultList.size() >= 1){
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public int updateSysUser(CrmSysUser crmSysUserOld, CrmSysUser crmSysUserNew) {
        CrmSysUserExample updateCondition = new CrmSysUserExample();
        updateCondition.createCriteria().andVersionEqualTo(crmSysUserOld.getVersion())
                .andLoginNameEqualTo(crmSysUserOld.getLoginName())
                .andIsDeletedEqualTo(InternalConstants.NOT_DELETED);
        crmSysUserNew.setVersion(crmSysUserOld.getVersion() + 1);
        crmSysUserNew.setUpdateTime(new Date());
        crmSysUserNew.setLoginPassword(Md5Handler.convertMd5Small32(crmSysUserNew.getLoginPassword()));
        int cnt = crmSysUserMapper.updateByExampleSelective(crmSysUserNew, updateCondition);
        return cnt;
    }


}