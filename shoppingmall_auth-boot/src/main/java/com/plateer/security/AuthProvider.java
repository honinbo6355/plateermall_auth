package com.plateer.security;

import com.plateer.domain.dto.UserDto;
import com.plateer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        String userPw = authentication.getCredentials().toString();
        return authenticate(userId, userPw);
    }

    private Authentication authenticate(String id, String pw) throws AuthenticationException {
        UserDto user = new UserDto();
        user = userService.getMemberByUserEmail(id);
        if ( user == null || !user.getPassword().equals(pw)) {
            log.error("{} is not exist or password is not equals", id);
            return null;
        }

        return new MyAuthentication(id, pw, user);
    }

    @Override
    public boolean supports(Class authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }


}
