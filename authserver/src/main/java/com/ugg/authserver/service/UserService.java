/**
 * Copyright (C), 2015-2019
 * FileName: UserService
 * Author:   DUJE003
 * Date:     2019/6/6 17:36
 * Description: 用户操作服务
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.service;

import com.ugg.authserver.controller.authmanagement.vo.UserVo;
import com.ugg.authserver.entity.CrmSysUser;

/**
 * 用户操作服务<br> 
 *
 * @author DUJE003
 * @create 2019/6/6
 * @since 1.0.0
 */
public interface UserService {

    /**
     * 注册系统用户
     * @param user
     * @return
     */
    int addSysUser(CrmSysUser user);

    /**
     * 查询系统用户信息
     * @param loginName
     * @return
     */
    CrmSysUser findSysUserByLoginName(String loginName);

    /**
     * 更新系统用户信息
     * @param crmSysUserOld
     * @param crmSysUserNew
     * @return
     */
    int updateSysUser(CrmSysUser crmSysUserOld, CrmSysUser crmSysUserNew);
}
