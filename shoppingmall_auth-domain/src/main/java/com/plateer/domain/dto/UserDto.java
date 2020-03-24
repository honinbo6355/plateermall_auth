package com.plateer.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private String email;
    private String name;
    private String password;
    private String phoneNumber;
    private String firstAddress;
    private String secondAddress;
    private String thirdAddress;
    private String mainAddress;
    private String smsAlarm;
    private String emailAlarm;

    public UserDto(String email, String name, String password, String phoneNumber){
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
