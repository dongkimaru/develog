package com.co.kr.develog.user.member;

import com.co.kr.develog.DataNotFoundExcetpion;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final HttpSession httpSession;

    // 회원 생성
    @Override
    public void createMember(MemberForm model) {
        memberRepository.save(MemberEntity.builder()
                .name(model.getName())
                .password(model.getPassword())
                .birth(model.getBirth())
                .address(model.getAddress())
                .phone(model.getPhone())
                .email(model.getEmail())
                .education(model.getEducation())
                .build());
    }

    @Override
    public LoginResult login(LoginForm form) {

        var getEmail = memberRepository.findEmailByEmail(form.getEmail());
        if(getEmail.isEmpty()) {
            throw new DataNotFoundExcetpion("데이터가 존재하지 않습니다.");
        }
        var getMember = memberRepository.findByEmailAndPassword(form.getEmail(), form.getPassword());
        if (!form.getPassword().equals(getMember.getPassword())) {
            throw new DataNotFoundExcetpion("비밀번호가 일치하지 않습니다.");
        }

        return LoginResult.builder().
                id(getMember.getId()).
                name(getMember.getName()).
                birth(getMember.getBirth()).
                address(getMember.getAddress()).
                phone(getMember.getPhone()).
                email(getMember.getEmail()).
                education(getMember.getEducation()).
                build();
    }
}
