/**
 * Copyright (C), 2015-2019
 * FileName: UserManagementController
 * Author:   DUJE003
 * Date:     2019/6/6 17:34
 * Description: 用户的增删改查处理
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.controller.authmanagement;

import com.ugg.authserver.constants.InternalConstants;
import com.ugg.authserver.controller.authmanagement.vo.UserVo;
import com.ugg.authserver.controller.vo.ResultVo;
import com.ugg.authserver.entity.CrmSysUser;
import com.ugg.authserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 用户的增删改查处理<br>
 *
 *
 * @author DUJE003
 * @create 2019/6/6
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping(path = "/auth/userManager")
public class UserManagementController {

    @Autowired
    UserService userService;

    /**
     * 注册新的系统用户
     */
    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public ResultVo<String> regNewSysUser(@RequestBody UserVo user){
        log.info("===============regNewSysUser===============start{}", user.toString());
        ResultVo<String> result = new ResultVo<String>();
        if(StringUtils.isEmpty(user.getLoginName())){
            result.setMsg("用户名不能为空");
            result.setMsgCode(InternalConstants.ERROR_CODE);
            return result;
        }
        if(StringUtils.isEmpty(user.getLoginPassword())){
            result.setMsg("用户密码不能为空");
            result.setMsgCode(InternalConstants.ERROR_CODE);
            return result;
        }
        // TODO: 密码策略配置逻辑

        CrmSysUser crmSysUser = null;
        BeanUtils.copyProperties(user, crmSysUser = new CrmSysUser());

        try{
            int count;
            if((count = userService.addSysUser(crmSysUser)) == 1){
                result.setMsg("用户插入成功");
                result.setMsgCode(InternalConstants.SUCCESS_CODE);
            }else{
                result.setMsg("用户插入失败");
                result.setMsgCode(InternalConstants.SUCCESS_CODE);
            }
            result.setResult(count + "");
        } catch(DuplicateKeyException ex){
            result.setMsg("已有此用户");
            result.setMsgCode(InternalConstants.ERROR_CODE);
        }
        log.info("===============regNewSysUser===============end");
        return result;
    }

    /**
     * 查询系统用户
     */
    @RequestMapping(path = "/searchSysUser/{loginName}")
    public ResultVo<UserVo> searchSysUser(@PathVariable("loginName") String loginName){
        log.info("===============searchSysUser===============start{}", loginName);
        ResultVo<UserVo> resultVo = new ResultVo<UserVo>();
        CrmSysUser crmSysUser = userService.findSysUserByLoginName(loginName);
        UserVo userVo;
        if(crmSysUser != null){
            BeanUtils.copyProperties(crmSysUser, userVo = new UserVo());
            resultVo.setMsg("查询成功");
            resultVo.setMsgCode("0");
            resultVo.setResult(userVo);
        } else {
            resultVo.setMsg("未查询到该用户");
            resultVo.setMsgCode("0");
        }
        log.info("===============searchSysUser===============end");
        return resultVo;
    }

    /**
     * 更新系统用户
     */
    @RequestMapping(path="/updateSysUserInfo", method = RequestMethod.PUT)
    public ResultVo<UserVo> updateSysUserInfo(@RequestBody UserVo user){
        log.info("===============updateSysUserInfo===============start{}", user);
        CrmSysUser crmSysUserNew = null;
        BeanUtils.copyProperties(user, crmSysUserNew = new CrmSysUser());
        ResultVo<String> result = new ResultVo<String>();
        CrmSysUser crmSysUserOld = userService.findSysUserByLoginName(user.getLoginName());
        if(crmSysUserOld == null){
            result.setMsgCode(InternalConstants.SUCCESS_CODE);
            result.setMsg("未找到该用户");
        }
        int cnt = userService.updateSysUser(crmSysUserOld, crmSysUserNew);
        if(cnt == 0){
            result.setMsgCode(InternalConstants.ERROR_CODE);
            result.setMsg("该用户信息已被更新");
        }
        log.info("===============updateSysUserInfo===============end");
        return null;
    }
}