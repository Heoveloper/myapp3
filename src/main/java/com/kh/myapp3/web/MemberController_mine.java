//package com.kh.myapp3.web;
//
//import com.kh.myapp3.domain.dao.Member;
//import com.kh.myapp3.domain.svc.MemberSVC;
//import com.kh.myapp3.web.form.member_mine.EditForm;
//import com.kh.myapp3.web.form.member_mine.JoinForm;
//import com.kh.myapp3.web.form.member_mine.MemberForm;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Slf4j
//@Controller
//@RequestMapping("/members")
//@RequiredArgsConstructor
//public class MemberController_mine {
//
//    private final MemberSVC memberSVC;
//
//    //등록 양식
//    @GetMapping("/add")
//    public String joinForm() {
//
//        return "member_mine/joinForm";   //회원등록 view
//    }
//
//    //등록 처리
//    @PostMapping("/add")
//    public String join(JoinForm joinForm) {
//
//        Member member = new Member();
//        member.setMemberId(joinForm.getMemberId());
//        member.setEmail(joinForm.getEmail());
//        member.setPw(joinForm.getPw());
//        member.setNickname(joinForm.getNickname());
//
//        Member joinedMember = memberSVC.insert(member);
//
//        return "redirect:/members/"+joinedMember.getMemberId();
//    }
//
//    //회원 개별 조회
//    @GetMapping("/{mid}")
//    public String findByMemberId(
//            @PathVariable("mid") Long mid, Model model
//    ) {
//        Member findedMember = memberSVC.findById(mid);
//
//        MemberForm memberForm = new MemberForm();
//        memberForm.setMemberId(findedMember.getMemberId());
//        memberForm.setEmail(findedMember.getEmail());
//        memberForm.setPw(findedMember.getPw());
//        memberForm.setNickname(findedMember.getNickname());
//        memberForm.setCdate(findedMember.getCdate());
//        memberForm.setUdate(findedMember.getUdate());
//
//        model.addAttribute("memberForm", memberForm);
//
//        return "member_mine/memberForm";
//    }
//
//    //수정 양식
//    @GetMapping("/{mid}/edit")
//    public String editForm(
//            @PathVariable("mid") Long mid, Model model
//    ) {
//
//        return "member_mine/editForm";
//    }
//
//    //수정 처리
//    @PostMapping("/{mid}/edit")
//    public String edit(
//            @PathVariable("mid") Long mid, EditForm editForm
//    ) {
//
//        Member member = new Member();
//        member.setMemberId(mid);
//        member.setEmail(editForm.getEmail());
//        member.setPw(editForm.getPw());
//        member.setNickname(editForm.getNickname());
//        member.setCdate(editForm.getCdate());
//        member.setUdate(editForm.getUdate());
//
//        memberSVC.update(mid, member);
//        return "redirect:/members/"+mid;
//    }
//
//    //삭제 처리
//    @GetMapping("/{mid}/del")
//    public String del(
//            @PathVariable("mid") Long mid
//    ) {
//
//        memberSVC.del(mid);
//        return "redirect:/members";
//    }
//
//    //목록
//    @GetMapping
//    public String all(Model model) {
//
//        List<Member> list = memberSVC.all();
//        model.addAttribute("list", list);
//        return "member_mine/all";
//    }
//}
