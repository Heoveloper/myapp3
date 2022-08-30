package com.kh.myapp3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    //등록 양식
    @GetMapping
    public String saveForm() {

        return "product/saveForm";      //상품등록 view
    }

    //등록 처리
    @PostMapping
    public String saver() {

        return "redirect:product/1";    //상품상세 view
    }

    //상품 개별 조회
    @GetMapping("/{pid}")
    public String findByProductId(@PathVariable("pid") String pid) {
        //DB에서 상품조회

        return "product/detailForm";    //상품상세 view
    }

    //수정 양식
    @GetMapping("/{pid}/edit")
    public String updateForm() {

        return "product/updateForm";    //상품수정 view
    }


    //수정 처리
    @PostMapping("/{pid}/edit")
    public String update() {

        return "redirect:/product/1";    //상품상세 view
    }

}
