package com.plateer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.UserDao;
import com.plateer.domain.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private JwtService jwtService;

    public UserServiceImpl(UserDao userDao, JwtService jwtService) {
        this.userDao = userDao;
        this.jwtService = jwtService;
    }

    @Override
    public void signUp(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userDao.signUp(user);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    public String validateUser(User user) {
        String msg;
        boolean result;
        User loginUser = getUserByEmail(user.getEmail());
        if(loginUser == null){
            msg = "noExist";
        }else{
            result = BCrypt.checkpw(user.getPassword(),loginUser.getPassword());
            if(result){
                msg = "success";
            }else{
                msg = "incorrect";
            }
        }
        return msg;
    }

    public User getCurrentUserInfo(){
        ObjectMapper objectMapper = new ObjectMapper();
        User test = objectMapper.convertValue(jwtService.get("member"),User.class);
        return test;
    }

    @Override
    public void updateUserInfo(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userDao.updateUser(user);
    }
}
