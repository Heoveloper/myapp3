package com.kh.myapp3.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long memberId;          //회원아이디(내부관리용) MEMBER_ID	NUMBER(8,0)	No	"C##SPRINGBOOT"."MEMBER_MEMBER_ID_SEQ"."NEXTVAL"	1
    private String email;           //이메일 EMAIL	VARCHAR2(40 BYTE)	Yes		2
    private String pw;              //비밀번호 PW	VARCHAR2(10 BYTE)	Yes		3
    private String nickname;        //별칭 NICKNAME	VARCHAR2(30 BYTE)	No		4
    private LocalDateTime cdate;    //생성일 CDATE	TIMESTAMP(6)	No	SYSTIMESTAMP    5
    private LocalDateTime udate;    //수정일 UDATE	TIMESTAMP(6)	No	SYSTIMESTAMP   6

    public Member(String email, String pw, String nickname) {
        this.email = email;
        this.pw = pw;
        this.nickname = nickname;
    }

    //Setter

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUdate(LocalDateTime udate) {
        this.udate = udate;
    }

    //Getter

    public Long getMemberId() {
        return memberId;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    public String getNickname() {
        return nickname;
    }

    public LocalDateTime getCdate() {
        return cdate;
    }

    public LocalDateTime getUdate() {
        return udate;
    }
}
