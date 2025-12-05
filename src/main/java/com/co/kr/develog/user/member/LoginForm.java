package com.co.kr.develog.user.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

    @NotBlank(message = "이메일을 입력하세요.")
    @Email(message = "올바른 이메일 형식을 입력하세요.")
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;
}
