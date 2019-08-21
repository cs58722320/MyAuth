/**
 * Copyright (C), 2015-2019
 * FileName: AuthValidateFilter
 * Author:   DUJE003
 * Date:     2019/6/10 21:41
 * Description: 用户授权认证过滤器
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.arvato.auth.client.filter;

import com.arvato.auth.client.config.AuthClientProperties;
import com.arvato.auth.client.entity.CrmSysAuth;
import com.arvato.auth.client.entity.CrmSysAuthExample;
import com.arvato.auth.client.mapper.CrmSysAuthDefaultMapper;
import com.arvato.auth.client.util.JWTUtils;
import io.jsonwebtoken.Claims;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户授权认证过滤器<br>
 *
 * @author DUJE003
 * @create 2019/6/10
 * @since 1.0.0
 */
@Slf4j
@Setter
public class DefaultAuthValidateFilter implements Filter {

    /**
     * 缓存模板
     */
    RedisTemplate redisTemplate;

    /**
     * 角色授权数据操作
     */
    CrmSysAuthDefaultMapper crmSysAuthDefaultMapper;

    /**
     * 授权客户端配置信息
     */
    AuthClientProperties authClientProperties;

    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("AuthValidateFilter start");
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        redisTemplate = ctx.getBean("redisTemplate", RedisTemplate.class);
        crmSysAuthDefaultMapper = ctx.getBean("crmSysAuthDefaultMapper", CrmSysAuthDefaultMapper.class);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String jwtToken = httpServletRequest.getParameter("token");
        List<Integer> roleIds = null;
        String loginName = null;
        String url = httpServletRequest.getRequestURI();

        // 判断路径是否需要被验证
        if (validateUrl(authClientProperties.getNoAuthUrl(), url)){
            log.info("该路径不需要权限认证{}", url);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        try {
            log.info("获取到得Token：{}", jwtToken);
            Claims claims = JWTUtils.parseJWT(jwtToken);
            loginName = claims.get("loginName", String.class);
            // 判断是否是超级用户
            if (authClientProperties.getAdminAccount().contains(loginName)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            roleIds = claims.get("roles", java.util.List.class);
        } catch (Exception e) {
            httpServletResponse.setStatus(405);
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.getWriter().print("token认证失败。请重新获取token");
            log.warn("token认证失败。请重新获取token");
            return;
        }
        Set<String> auths = new HashSet();
        roleIds.stream().forEach(a ->{
            try {
                auths.addAll(redisTemplate.opsForSet().members(a));
            }catch (Exception ex){
                log.error("redis获取权限异常", ex);
                // 从关系数据库中获取
                CrmSysAuthExample condition = new CrmSysAuthExample();
                condition.createCriteria().andRoleIdEqualTo(a).andIsDeletedEqualTo(false);
                List<CrmSysAuth> crmSysAuths = crmSysAuthDefaultMapper.selectByExample(condition);
                List<String> authList = crmSysAuths.stream().map(CrmSysAuth::getAccessPath).collect(Collectors.toList());
                auths.addAll(authList);
            }
        });

        if (validateUrl(auths, url)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.setStatus(405);
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.getWriter().print("该用户没有访问该资源权限。");
            log.warn("该用户没有访问该资源权限。loginName={},path={}", loginName, url);
            return;
        }
    }

    public void destroy() {
        log.info("AuthValidateFilter end");
    }

    /**
     * 验证该角色URL是否被授权
     *
     * @param permittedUrlList
     * @param currentUrl
     * @return
     */
    private boolean validateUrl(Collection<String> permittedUrlList, String currentUrl){
        if(permittedUrlList.size() == 0){
            log.info("权限列表为空，未获取到权限");
            return false;
        }
        return permittedUrlList.stream().filter(a -> currentUrl.contains(a)).collect(Collectors.toList()).size() > 0;
    }
}