package com.plateer;

import com.plateer.domain.User;

public interface UserDao {
    void signUp(User user);
    User getUserByEmail(String email);
}
