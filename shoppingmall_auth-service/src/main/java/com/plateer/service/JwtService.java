package com.plateer.service;

import java.util.Map;

public interface JwtService {
    <T> String create(String key, T data, String subject);
    Map<String, Object> get(String key, String token);
    boolean isUsable(String jwt);

}
