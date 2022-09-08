package com.kh.myapp3.web.admin;

import com.kh.myapp3.domain.Member;
import com.kh.myapp3.domain.admin.AdminMemberSVC;
import com.kh.myapp3.web.admin.form.member.AddForm;
import com.kh.myapp3.web.admin.form.member.EditForm;
import com.kh.myapp3.web.admin.form.member.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/members")
@RequiredArgsConstructor
public class AdminMemberController {

    private final AdminMemberSVC adminMemberSVC;

    //등록화면
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("form", new AddForm());
        return "admin/member/addForm";    //등록 화면
    }

    //등록처리
    @PostMapping("/add")
    public String add(
            @Valid @ModelAttribute("form") AddForm addForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes   //리다이렉트할 때 정보를 유지하기 위해 사용
    ) {
        //검증로직
//        @ModelAttribute 어노테이션이 만들어준다 ↓
//        model.addAttribute("addForm", form);
        log.info("addForm={}", addForm);
//        if(addForm.getEmail() == null || addForm.getEmail().trim().length() == 0) {
//
//            return "admin/member/addForm_old";  //등록 화면 다시 띄우기
//        }
        if(bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "admin/member/addForm";
        }
        //회원아이디 중복체크
        Boolean isExist = adminMemberSVC.dupChkOfMemberEmail(addForm.getEmail());
        if(isExist) {
            bindingResult.rejectValue("email", "dup.email", "동일한 이메일이 존재합니다.");
            return "admin/member/addForm";

        }

        //회원등록
        Member member = new Member();
        member.setEmail(addForm.getEmail());
        member.setPw(addForm.getPw());
        member.setNickname(addForm.getNickname());
        Member insertedMember = adminMemberSVC.insert(member);

        Long id = insertedMember.getMemberId();
        redirectAttributes.addAttribute("id", id);
        return "redirect:/admin/members/{id}"; //회원 상세 화면
    }

    //등록처리 백업
    public String add2(@Valid @ModelAttribute AddForm addForm, BindingResult bindingResult) {
        //검증로직
//        @ModelAttribute 어노테이션이 만들어준다 ↓
//        model.addAttribute("addForm", form);
        log.info("addForm={}", addForm);
//        if(addForm.getEmail() == null || addForm.getEmail().trim().length() == 0) {
//
//            return "admin/member/addForm_old";  //등록 화면 다시 띄우기
//        }
        if(bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "admin/member/addForm_old";
        }

        //비즈니스 규칙 체크(개발자로직 체크)
        //1) 이메일에 @가 없으면 오류 (Validation의 @Email 어노테이션으로도 가능한데 코드 연습)
        if(!addForm.getEmail().contains("@")) {

            //rejectValue: 오류필드, 에러코드, 디폴트메세지(정의된 메세지가 없으면 띄워짐)
            bindingResult.rejectValue("email", "emailChk1","이메일 형식에 맞지 않습니다.");
            return "admin/member/addForm_old";
        }
        if(addForm.getEmail().length() > 5) {

            //rejectValue: 오류필드, 에러코드, 아규먼트(전달인자), 디폴트메세지(정의된 메세지가 없으면 띄워짐)
            bindingResult.rejectValue("email", "emailChk2", new String[]{"0", "5"}, "이메일 길이가 초과되었습니다.");
            return "admin/member/addForm_old";
        }
        //2) ObjectError: 2개 이상의 필드 분석을 통해 오류 검증
        //      비밀번호, 별칭의 자리수가 모두 5미만인 경우 (코드 연습)
        if(addForm.getPw().trim().length() < 5 && addForm.getNickname().trim().length() < 5) {

            //reject: 필드정보가 없다.
            bindingResult.reject("memberChk", new String[]{"5"}, "비밀번호, 별칭의 자리수가 모두 5 미만입니다.");
            return "admin/member/addForm_old";
        }



        //회원등록
        Member member = new Member();
        member.setEmail(addForm.getEmail());
        member.setPw(addForm.getPw());
        member.setNickname(addForm.getNickname());
        Member insertedMember = adminMemberSVC.insert(member);

        return "redirect:/admin/members/" + insertedMember.getMemberId(); //회원 상세 화면
    }

    //조회화면
    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        Member findedMember = adminMemberSVC.findById(id);

        MemberForm memberForm = new MemberForm();
        memberForm.setMemberId(findedMember.getMemberId());
        memberForm.setEmail(findedMember.getEmail());
        memberForm.setPw(findedMember.getPw());
        memberForm.setNickname(findedMember.getNickname());
        memberForm.setCdate(findedMember.getCdate());
        memberForm.setUdate(findedMember.getUdate());

        model.addAttribute("memberForm", memberForm);
        return "admin/member/memberForm"; //회원 상세 화면
    }

    //수정화면
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model) {

        Member findedMember = adminMemberSVC.findById(id);

        EditForm editForm = new EditForm();
        editForm.setMemberId(findedMember.getMemberId());
        editForm.setEmail(findedMember.getEmail());
        editForm.setPw(findedMember.getPw());
        editForm.setNickname(findedMember.getNickname());

        model.addAttribute("editForm", editForm);
        return "admin/member/editForm";  //회원 수정화면
    }

    //수정처리
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, EditForm editForm) {

        Member member = new Member();
        member.setPw(editForm.getPw());
        member.setNickname(editForm.getNickname());

        int updatedRow = adminMemberSVC.update(id, member);
        if(updatedRow == 0) {
            return "admin/member/editForm";
        }
        return "redirect:/admin/members/{id}";    //회원 상세화면
    }

    //삭제처리
    @GetMapping("/{id}/del")
    public String del(@PathVariable("id") Long id) {
        int deletedRow = adminMemberSVC.del(id);
        if(deletedRow == 0) {
            return "redirect:/admin/members/"+id;
        }
        return "redirect:/admin/members/all";   //회원 목록화면
    }

    //목록화면
    @GetMapping("/all")
    public String all(Model model) {

        List<Member> list = adminMemberSVC.all();

        model.addAttribute("list", list);
        return "admin/member/all";
    }

}
