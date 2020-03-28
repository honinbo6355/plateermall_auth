package com.plateer.service;

import com.plateer.domain.User;

import java.util.Map;

public interface JwtService {
    String create(String key, User data);
    Map<String, Object> get(String key);
    boolean isUsable(String jwt);

}
