package com.plateer.domain;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String uuid;
    private String email;
    private String name;
}
