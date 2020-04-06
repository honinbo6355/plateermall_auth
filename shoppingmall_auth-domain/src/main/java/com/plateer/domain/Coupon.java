package com.plateer.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Coupon {
    private int cp_id;
    private String cp_name;
    private String cp_type;
    private int cp_rate;
    private Date cp_expired_dt;
}
