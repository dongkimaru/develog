package com.co.kr.develog.user.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    @Query("SELECT m.email FROM MemberEntity m WHERE m.email = :email")
    String findEmailByEmail(@Param("email") String email);

    MemberEntity findByEmailAndPassword(String email, String password);
}
