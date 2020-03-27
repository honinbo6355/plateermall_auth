package com.plateer.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeliveryAddress {
    private int id;
    private String type;
    private String email;
    private String address;
}
