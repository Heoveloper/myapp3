package com.kh.myapp3.web.form.member;

import lombok.Data;

@Data
public class EditForm {
    private String email;
    private String pw;          //비밀번호
    //private String pwchk;       //비밀번호 확인
    private String nickname;    //별칭
}
