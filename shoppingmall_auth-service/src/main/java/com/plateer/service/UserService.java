package com.plateer.service;

import com.plateer.domain.User;

public interface UserService {
    void signUp(User user);

    User getUserByEmail(String email);

    User signin(String email, String password);
}
