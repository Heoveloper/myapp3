package com.kh.myapp3.web;

import com.kh.myapp3.domain.svc.MemberSVC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberSVC memberSVC;

    //가입화면 GET /members/add
    @GetMapping("/add")
    public String addForm() {

        return "member/addForm";    //가입 화면
    }

    //가입처리 POST /members/add
    @PostMapping("/add")
    public String add() {

        return "login/loginForm";   //로그인 화면
    }

    //조회화면 GET /members/{id}
    @GetMapping("/{id}")
    public String findById() {

        return "member/memberForm"; //회원 상세 화면
    }

    //수정화면 GET /members/{id}/edit
    @GetMapping("/{id}/edit")
    public String editForm() {

        return "/member/editForm";  //회원 수정화면
    }

    //수정처리 POST /members/{id}/edit
    @PostMapping("/{id}/edit")
    public String edit() {

        return "redirect:/members/{id}";    //회원 상세화면
    }

    //탈퇴화면
    @GetMapping("/{id}/del")
    public String delForm() {

        return "member/delForm";    //회원 탈퇴화면
    }

    //탈퇴처리 GET /members/{id}/del
    @PostMapping("/{id}/del")
    public String del() {

        return "redirect:/";
    }

    //목록화면 GET /members
    @GetMapping("/all")
    public String all() {

        return "member/all";
    }


}
