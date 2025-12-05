package com.co.kr.develog.user.member;

import org.springframework.ui.Model;

public interface MemberService {

    void createMember(MemberForm model);

    LoginResult login(LoginForm form);

}
