package com.kh.myapp3.web.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginForm {
    @NotBlank
    @Email(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "이메일 형식이 아닙니다.")
    private String email;
    @NotBlank
    @Size(min = 0, max = 10)
    private String pw;
}
