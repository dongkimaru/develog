package com.co.kr.develog.user.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResult {
    private int id;
    private String name;
    private String birth;
    private String address;
    private String phone;
    private String email;
    private String education;
}
