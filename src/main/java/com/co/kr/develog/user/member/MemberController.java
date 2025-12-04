package com.co.kr.develog.user.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createMember(MemberForm model) {

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(model.getPassword());

        MemberEntity member = MemberEntity.builder()
                .name(model.getName())
                .birth(model.getBirth())
                .address(address)
                .phone(model.getPhone())
                .email(model.getEmail())
                .education(model.getEducation())
                .password(encodedPassword)
                .build();

        memberRepository.save(member);
    }
}
