package com.kh.myapp3;

import com.kh.myapp3.domain.dao.Member;
import com.kh.myapp3.domain.svc.MemberSVC;
import com.kh.myapp3.web.form.LoginForm;
import com.kh.myapp3.web.session.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    final MemberSVC memberSVC;

    @GetMapping
    public String home() {
        //세션이 존재하면 로그인 후 화면 이동
        //세션이 존재하지 않으면 로그인 전 화면 이동

        return "beforeLogin";
    }

    //로그인 화면
    @GetMapping("login")
    public String loginForm(@ModelAttribute("form") LoginForm loginForm) {

        return "login";
    }

    //로그인 처리
    @PostMapping("login")
    public String login(
            @Valid @ModelAttribute("form") LoginForm loginForm,
            BindingResult bindingResult,
            HttpServletRequest request
    ) {
        //검증 로직

        //기본 검증
        if (bindingResult.hasErrors()) {
            return "login";
        }

        //회원 유무
        Optional<Member> member = memberSVC.login(loginForm.getEmail(), loginForm.getPw());
        if (member.isEmpty()) {
            bindingResult.reject("LoginForm.login", "회원정보가 없습니다.");
            return "login";
        }

        //회원인 경우
        Member findedMember = member.get();

        //세션에 회원정보 저장
        LoginMember loginMember = new LoginMember(findedMember.getEmail(), findedMember.getNickname());
        HttpSession session = request.getSession(true);
        session.setAttribute("LoginMember", loginMember);


        return "afterLogin";
    }
}
