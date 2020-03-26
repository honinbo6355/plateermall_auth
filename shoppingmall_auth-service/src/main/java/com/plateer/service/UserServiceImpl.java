package com.plateer.service;

import com.plateer.UserDao;
import com.plateer.domain.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void signUp(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        userDao.signUp(user);
    }

    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public User signin(String email, String password) {
//        UserDto users = usersRepository.findByEmail(email);
//        Objects.requireNonNull(users, SIGNIN_EXCEPTION_MSG);
//
//        if( ! this.isAccordPassword(users, password)){
//            throw new IllegalStateException(SIGNIN_EXCEPTION_MSG);
//        }

        return new User(email, "1234","danbi", "phoneNumber",null,null,null,null,false,false);
    }

}
