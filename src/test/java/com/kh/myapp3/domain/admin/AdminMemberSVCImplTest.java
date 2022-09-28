package com.kh.myapp3.domain.admin;

import com.kh.myapp3.domain.dao.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AdminMemberSVCImplTest {

    @Autowired
    private AdminMemberSVC adminMemberSVC;

    @Test
    @DisplayName("회원번호 생성 후 회원가입")
    void insert() {
        Member member = new Member();
        member.setEmail("test42@test.com");
        member.setPw("1234");
        member.setNickname("홍길동");

        Member joinedMember = adminMemberSVC.insert(member);
        log.info("joinedMember = {}", joinedMember);
    }
}
