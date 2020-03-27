package com.plateer.controller.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class TokenUtil {
    private static final String SALT = "luvookSecret";

    public String getToken(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();

        String token = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }
        }

        return token;
    }

    public String getUserEmail(){
        String token = getToken();

        if(token!=null){
            Jws<Claims> claims = null;
            try {
                claims = Jwts.parser()
                        .setSigningKey(SALT.getBytes("UTF-8"))
                        .parseClaimsJws(token);
            } catch (Exception e) {
                if (log.isInfoEnabled()) {
                    e.printStackTrace();
                } else {
                    log.error(e.getMessage());
                }
                return null;
            }

            String test = (String)claims.getBody().get("member");
//            @SuppressWarnings("unchecked")
//            Map<String, Object> value = (LisnkedHashMap<String, Object>) claims.getBody().get("member");
//            System.out.println(value);
            System.out.println("테스트 값 claims==="+test);
            return "";
        }else{
            return null;
        }
    }
}
