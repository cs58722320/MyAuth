/**
 * Copyright (C), 2015-2019
 * FileName: LoginService
 * Author:   DUJE003
 * Date:     2019/6/7 23:30
 * Description: 登陆服务
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.service;

import java.util.List;
import java.util.Map;

/**
 * 登陆服务<br> 
 *
 * @author DUJE003
 * @create 2019/6/7
 * @since 1.0.0
 */
public interface LoginService {

    /**
     * 验证用户名密码是否有效
     * @param loginname
     * @param password
     * @return
     */
    boolean identifyUserInfo(String loginname, String password);

    /**
     * 得到用户的角色
     * @param loginName
     * @return
     */
    List<Integer> getUserRole(String loginName);

    /**
     * 根据payload生成JWTToken
     * @param payload
     * @return
     */
    String generateToken(Map<String, Object> payload);

    /**
     * 记录授权历史
     * @param userName
     * @param ipAddr
     */
    void loginRecord(String userName, String ipAddr);

}
