package com.plateer.service;

import java.util.Map;

public interface JwtService {
    String create(String key, String data, String subject);
    Map<String, Object> get(String key, String token);
    boolean isUsable(String jwt);

}
