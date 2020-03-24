package com.plateer.security;

import com.plateer.domain.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
public class MyAuthentication extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 1L;

    UserDto userDto;

    public MyAuthentication(String id, String pw, UserDto userDto) {
        super(id, pw);
        this.userDto = userDto;
    }

}
