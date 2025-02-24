package com.blog.appcenter_blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    //회원가입 페이지 출력 요청
    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

//    @PostMapping("/signup")
//    public String signup(){
//
//    }


}
