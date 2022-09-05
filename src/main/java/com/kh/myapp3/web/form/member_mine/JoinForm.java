package com.kh.myapp3.web.form.member_mine;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class JoinForm {
    private Long memberId;  //회원아이디   MEMBER_ID	NUMBER(8,0)	No		1
    private String email;   //이메일   EMAIL	VARCHAR2(40 BYTE)	Yes		2
    private String pw;  //비밀번호  PW	VARCHAR2(10 BYTE)	Yes		3
    private String nickname;    //별칭    NICKNAME	VARCHAR2(30 BYTE)	No		4
    private LocalDateTime cdate; //가입일자  CDATE	TIMESTAMP(6)	No	systimestamp	5
    private LocalDateTime udate;//수정일자  UDATE	TIMESTAMP(6)	No	systimestamp    6
}
