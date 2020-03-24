package com.plateer.service;

import com.plateer.domain.dto.UserDto;

public class UserServiceImpl implements UserService {
    public UserDto getMemberByUserEmail(String email) {
        return new UserDto(email, "name", "password", "phoneNumber");
    }
}
