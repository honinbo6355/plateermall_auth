package com.plateer.domain;

import lombok.*;

import java.util.List;


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
    private int point;
    private String coupons;

    private List<Coupon> couponList;
}
