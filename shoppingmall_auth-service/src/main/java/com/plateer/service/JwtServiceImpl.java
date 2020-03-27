package com.plateer.service;

import com.plateer.error.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

    private static final String SALT = "luvookSecret";

    /**
     *
     * @param key : member
     * @param data : User
     * @param subject : user
     * @param <T>
     * @return
     */
    @Override
    public String create(String key, String data, String subject) {
        String jwt = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("regDate", System.currentTimeMillis())
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + 86400 * 1000 * 2))
                .claim(key, data)
                .signWith(SignatureAlgorithm.HS256, this.generateKey())
                .compact();
        return jwt;
    }

    private byte[] generateKey() {
        byte[] key = null;
        try {
            key = SALT.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (log.isInfoEnabled()) {
                e.printStackTrace();
            } else {
                log.error("Making JWT Key Error ::: {}", e.getMessage());
            }
        }

        return key;
    }

    @Override
    public Map<String, Object> get(String key, String token) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Cookie[] cookies = request.getCookies();
        String jwt;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                  jwt = cookie.getValue();
                }
            }
        }

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
        @SuppressWarnings("unchecked")
        Map<String, Object> value = (LinkedHashMap<String, Object>) claims.getBody().get(key);
        System.out.println(value);
        return value;
    }

    @Override
    public boolean isUsable(String jwt) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(this.generateKey())
                    .parseClaimsJws(jwt);
            return true;

        } catch (Exception e) {

            if (log.isInfoEnabled()) {
                e.printStackTrace();
            } else {
                log.error(e.getMessage());
            }
            return false;

        }
    }

}
