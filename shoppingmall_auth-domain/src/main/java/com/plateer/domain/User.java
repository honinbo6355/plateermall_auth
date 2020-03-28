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
    private boolean smsAgree;
    private boolean emailAgree;

}
