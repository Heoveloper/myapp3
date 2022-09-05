package com.kh.myapp3.web.form.member_mine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditForm {
    private Long memberId;
    private String email;
    private String pw;
    private String nickname;
    private LocalDateTime cdate;
    private LocalDateTime udate;
}
