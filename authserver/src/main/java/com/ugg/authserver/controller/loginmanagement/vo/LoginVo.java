/**
 * Copyright (C), 2015-2019
 * FileName: LoginVo
 * Author:   DUJE003
 * Date:     2019/6/7 23:27
 * Description: 登陆Vo
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.controller.loginmanagement.vo;

import lombok.Data;

/**
 * 登陆Vo<br> 
 *
 * @author DUJE003
 * @create 2019/6/7
 * @since 1.0.0
 */
@Data
public class LoginVo {

    /**
     * 用户名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;

}