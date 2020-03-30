package com.plateer.config;

import com.google.common.net.HttpHeaders;
import com.plateer.error.UnauthorizedException;
import com.plateer.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {
    private static final String HEADER_AUTH = "Authorization";

    private JwtService jwtService;

    public JwtInterceptor(JwtService jwtService){
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("JWT 인터셉터!!!!!!!!!!!!!");
        if(request.getHeader(HEADER_AUTH) != null){
            final String token = request.getHeader(HEADER_AUTH).split(" ")[1];
            if(token == null || !jwtService.isUsable(token)){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }else{
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
