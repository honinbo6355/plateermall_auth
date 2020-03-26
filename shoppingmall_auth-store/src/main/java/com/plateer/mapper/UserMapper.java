package com.plateer.mapper;

import com.plateer.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void signUp(User user);
    User getUserByEmail(String email);
}
