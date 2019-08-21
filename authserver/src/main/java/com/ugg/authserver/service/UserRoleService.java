/**
 * Copyright (C), 2015-2019
 * FileName: UserRoleService
 * Author:   DUJE003
 * Date:     2019/6/10 14:32
 * Description: 用户角色服务接口
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.service;

import com.ugg.authserver.entity.CrmSysAuth;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户角色服务接口<br> 
 *
 * @author DUJE003
 * @create 2019/6/10
 * @since 1.0.0
 */
public interface UserRoleService {

    public Map<Integer, List<CrmSysAuth>> getAuthMap();

}
