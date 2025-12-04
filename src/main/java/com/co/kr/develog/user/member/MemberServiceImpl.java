package com.co.kr.develog.user.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void createMember(MemberForm model) {
        memberRepository.save(MemberEntity.builder()
                .name(model.getName())
                .birth(model.getBirth())
                .address(model.getAddress())
                .phone(model.getPhone())
                .email(model.getEmail())
                .education(model.getEducation())
                .build());
    }
}
