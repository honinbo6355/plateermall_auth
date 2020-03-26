package com.plateer.domain;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String email;
    private String password;
    private String name;
    private String phoneNumber;
    private String firstAddress;
    private String secondAddress;
    private String thirdAddress;
    private String mainAddress;
    private boolean smsAgree;
    private boolean emailAgree;

}
