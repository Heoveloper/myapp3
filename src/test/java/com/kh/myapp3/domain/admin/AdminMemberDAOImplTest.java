package com.kh.myapp3.domain.admin;

import com.kh.myapp3.domain.dao.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

@Slf4j
@SpringBootTest //테스트 환경에서 Application 구동
//@Transactional //테스트 환경에서는 메소드 종료 전 롤백시킴(insert test 성공해도 DB에는 insert 안됨)
class AdminMemberDAOImplTest {

    @Autowired
    private AdminMemberDAO adminMemberDAO;

    @Test
    @DisplayName("더하기")
    void plus() {

        String str = "hello";
        String str2 = "world";
        String str3 = str + str2;
        log.info("str={} {} {}", str, str2, str3);
    }

    @Test
    @DisplayName("회원가입")
    //@Transactional
    @Disabled //테스트 대상에서 제외
    void insert() {

        Member member = new Member();
        member.setMemberId(502L);
        member.setEmail("test502@test.com");
        member.setPw("1234");
        member.setNickname("홍길동");
        int affectedRow = adminMemberDAO.insert(member);

        log.info("affectedRow = {}", affectedRow);
        Assertions.assertThat(affectedRow).isEqualTo(1);
    }

    //익셉션 발생 테스트
    @Test
    @DisplayName("회원아이디 중복")
    void insertThrow() {
        Member member = new Member();
        member.setMemberId(502L);
        member.setEmail("test502@test.com");
        member.setPw("1234");
        member.setNickname("홍길동");

        //insert method 실행시 duplicate-exception이면 성공
        org.junit.jupiter.api.Assertions.assertThrows(
                DuplicateKeyException.class,
                () -> adminMemberDAO.insert(member)
        );
    }

    @Test
    @DisplayName("회원조회: 회원 존재 O")
    void findById() {
        Member findedMember = adminMemberDAO.findById(1L);
        log.info("findedMember = {}", findedMember);
        Assertions.assertThat(findedMember.getNickname()).isEqualTo("별칭1");
    }

    @Test
    @DisplayName("회원조회: 회원 존재 X")
    void findByIdWhenIsNotExistMember() {
        Member findedMember = adminMemberDAO.findById(888L);
        Assertions.assertThat(findedMember).isNull();
    }

    @Test
    @DisplayName("회원목록")
    void all() {
        List<Member> list = adminMemberDAO.all();
        log.info("memberList = {}", list);
        log.info("memberCnt = {}", list.size());
//        for (Member member : list) {
//            log.info(member.toString());
//        }
        list.stream().forEach(member -> log.info(member.toString()));
    }

    @Test
    @DisplayName("회원수정")
    void update() {

        Long memberId = 500L;
        Member member = new Member();

//        member.setEmail("test500@test.com");
        member.setPw("500");
        member.setNickname("오백이");

        int affectedRow = adminMemberDAO.update(memberId, member);
        Member updatedMember = adminMemberDAO.findById(memberId);

        Assertions.assertThat(affectedRow).isEqualTo(1);
        Assertions.assertThat(updatedMember.getPw()).isEqualTo("500");
        Assertions.assertThat(updatedMember.getNickname()).isEqualTo("오백이");
    }

}