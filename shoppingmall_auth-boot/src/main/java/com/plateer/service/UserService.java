package com.plateer.service;

import com.plateer.domain.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto getMemberByUserEmail(String email);
}
