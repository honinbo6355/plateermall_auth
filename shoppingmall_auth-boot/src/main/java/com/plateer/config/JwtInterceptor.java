package com.plateer.config;

import com.plateer.error.UnauthorizedException;
import com.plateer.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private static final String HEADER_AUTH = "Authorization";

    private JwtService jwtService;

    public JwtInterceptor(JwtService jwtService){
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        final String token = request.getHeader(HEADER_AUTH).split(" ")[1];

        if(token != null && jwtService.isUsable(token)){
            return true;
        } else {
            throw new UnauthorizedException();
        }
    }
}
