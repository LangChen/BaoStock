package com.chlang.common.interceptor;

import com.chlang.common.exception.PlatfromException;
import com.chlang.common.helper.JwtHelper;
import com.chlang.common.resp.common.ErrorCode;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 全局拦截器
 */
@Component
public class PlatformInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(PlatformInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("--------进入拦截器--------");
        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String headName = headerNames.nextElement();
//            logger.info(headName + ":" + request.getHeader(headName));
//        }

        String authHeader = request.getHeader("Authorization");
        //判断是否传入令牌
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new PlatfromException(ErrorCode.TOKEN_FAILED_ERROR,"无效的令牌");
        }
        //验证令牌是否合法
        String token = authHeader.substring(7);
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        JwtHelper jwtHelper = (JwtHelper) factory.getBean("jwtHelper");
        Claims claims = jwtHelper.verifyToken(token);

        //从redis中获取用户信息

        //将用户信息存储到request的attr中

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
