package com.plateer.service;

import com.plateer.domain.User;

public interface UserService {
    void signUp(User user);

    User getUserByEmail(String email);

    String validateUser(User user);

    User getCurrentUserInfo();

    void updateUserInfo(User user);
}
