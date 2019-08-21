/**
 * Copyright (C), 2015-2019
 * FileName: UserVo
 * Author:   DUJE003
 * Date:     2019/6/6 18:18
 * Description: 系统用户Vo
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.controller.authmanagement.vo;

import lombok.Data;

/**
 * 系统用户Vo<br> 
 *
 * @author DUJE003
 * @create 2019/6/6
 * @since 1.0.0
 */
@Data
public final class UserVo {
    /**
     * 用户id
     */
    private String loginName;
    /**
     * 用户密码
     */
    private String loginPassword;
}