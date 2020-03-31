package com.plateer.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeliveryAddress {
    private int id;
    private int isDefault;
    private String userEmail;
    private String receiver;
    private String spotAlias;
    private String contactNumber;
    private String phoneNumber;
    private String roadAddress;
    private String zipcodeAddress;
    private String remainAddress;
}
