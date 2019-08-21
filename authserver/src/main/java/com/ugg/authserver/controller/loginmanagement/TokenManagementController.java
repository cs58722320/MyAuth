/**
 * Copyright (C), 2015-2019
 * FileName: TokenManagementController
 * Author:   DUJE003
 * Date:     2019/6/7 23:19
 * Description: JWTToken管理
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.controller.loginmanagement;

import com.ugg.authserver.constants.InternalConstants;
import com.ugg.authserver.controller.loginmanagement.vo.LoginVo;
import com.ugg.authserver.controller.vo.ResultVo;
import com.ugg.authserver.service.LoginService;
import com.ugg.authserver.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JWTToken管理<br> 
 *
 * @author DUJE003
 * @create 2019/6/7
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping(path = "/auth/tokenManager")
public final class TokenManagementController {

    @Autowired
    LoginService loginService;

    @RequestMapping(path = "/acquireJwtToken", method = RequestMethod.POST)
    public ResultVo<String> acquireJwtToken(@RequestBody LoginVo loginVo){
        log.info("===============acquireJwtToken===============start{}", loginVo.toString());
        ResultVo<String> result = new ResultVo<String>();
        if(StringUtils.isEmpty(loginVo.getLoginName())){
            result.setMsg("请填写用户名");
            result.setMsgCode(InternalConstants.ERROR_CODE);
            return result;
        }
        if(StringUtils.isEmpty(loginVo.getPassword())){
            result.setMsg("请填写密码");
            result.setMsgCode(InternalConstants.ERROR_CODE);
            return result;
        }
        // 获取IP地址
        String curIp = WebUtil.acquireRequestIp();
        boolean isValid = loginService.identifyUserInfo(loginVo.getLoginName(), loginVo.getPassword());
        loginService.loginRecord(loginVo.getLoginName(), curIp);
        if(!isValid){
            log.info("认证失败-UserName:{}", loginVo.getLoginName());
            result.setMsg("认证失败");
            result.setMsgCode(InternalConstants.ERROR_CODE);
            return result;
        }

        List<Integer> roleIds = loginService.getUserRole(loginVo.getLoginName());
        Map<String, Object> payload = new HashMap(2);
        payload.put("loginName", loginVo.getLoginName());
        payload.put("roles", roleIds);
        String jwtToken = loginService.generateToken(payload);
        result.setMsg("成功获取Token");
        result.setMsgCode(InternalConstants.SUCCESS_CODE);
        result.setResult(jwtToken);
        log.info("===============acquireJwtToken===============end");
        return result;
    }

}