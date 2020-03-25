package com.plateer.service;

import com.plateer.domain.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public UserDto getMemberByUserEmail(String email) {
        return new UserDto(email, "name", "password", "phoneNumber");
    }

    @Override
    public UserDto signin(String email, String password) {
//        UserDto users = usersRepository.findByEmail(email);
//        Objects.requireNonNull(users, SIGNIN_EXCEPTION_MSG);
//
//        if( ! this.isAccordPassword(users, password)){
//            throw new IllegalStateException(SIGNIN_EXCEPTION_MSG);
//        }

        return new UserDto("eks4116@gmail.com","danbi","password","01047264128");
    }
}
