package com.co.kr.develog.user.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberForm {

    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

    @NotBlank(message = "생년월일을 입력하세요.")
    private String birth;

    @NotBlank(message = "주소를 입력하세요.")
    private String address;

    @NotBlank(message = "연락처를 입력하세요.")
    @Pattern(
            regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",
            message = "연락처 형식이 올바르지 않습니다. 예) 010-1234-5678"
    )
    private String phone;

    @NotBlank(message = "이메일을 입력하세요.")
    @Email(message = "올바른 이메일 형식을 입력하세요.")
    private String email;

    @NotBlank(message = "학력을 선택하세요.")
    private String education;
}
