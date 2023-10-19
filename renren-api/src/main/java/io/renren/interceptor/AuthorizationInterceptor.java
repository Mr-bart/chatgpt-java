/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.interceptor;

import io.renren.annotation.Login;
import io.renren.commom.AsyncService;
import io.renren.commom.CommonService;
import io.renren.common.exception.ErrorCode;
import io.renren.common.exception.RenException;
import io.renren.entity.TokenEntity;
import io.renren.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 *
 * @author Mr.star 26011687@qq.com
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AsyncService asyncService;
    public static final String USER_KEY = "userId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //从header中获取token
        String token = request.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }

        //token为空
        if(StringUtils.isBlank(token)){
            RenException rrException = new RenException("token失效，请重新登录");
            rrException.setCode(8000);
            throw rrException;
        }

        //查询token信息
        TokenEntity tokenEntity = tokenService.getByToken(token);
        if(tokenEntity == null || tokenEntity.getExpireDate().getTime() < System.currentTimeMillis()){
            RenException rrException = new RenException("token失效，请重新登录");
            rrException.setCode(8000);
            throw rrException;
        }

        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(USER_KEY, tokenEntity.getUserId());
        asyncService.updateLoginTimeAndIp(tokenEntity.getUserId(),request);
        return true;
    }
}
