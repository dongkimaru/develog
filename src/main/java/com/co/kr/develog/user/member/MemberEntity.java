package com.co.kr.develog.user.member;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;
    private String name;
    private String password;
    private String birth;
    private String address;
    private String phone;
    private String education;
}
