package com.plateer.logic;

import com.plateer.UserDao;
import com.plateer.domain.User;
import com.plateer.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private UserMapper userMapper;

    public UserDaoImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public void signUp(User user) {
        userMapper.signUp(user);
    }

    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    public void updateUser(User user) {
        userMapper.update(user);
    }
}
