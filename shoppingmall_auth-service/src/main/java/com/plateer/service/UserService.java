package com.plateer.service;

import com.plateer.domain.dto.UserDto;

public interface UserService {
    UserDto getMemberByUserEmail(String email);

    UserDto signin(String email, String password);
}
