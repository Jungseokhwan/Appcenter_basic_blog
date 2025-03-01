package com.blog.appcenter_blog.controller;

import com.blog.appcenter_blog.dto.member.*;
import com.blog.appcenter_blog.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public ResponseEntity<MemberSignupResponseDto> signupUser(@RequestBody MemberSignupRequestDto memberSignupRequestDto) {
        MemberSignupResponseDto member = memberService.signupUser(memberSignupRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto login = memberService.loginUser(loginRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(login);
    }

    @Operation(summary = "회원 정보 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<MemberResponseDto> getMemberInfo(@PathVariable Long userId) {
        MemberResponseDto member = memberService.getMemberInfo(userId);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @Operation(summary = "전체 회원 조회")
    @GetMapping
    public ResponseEntity<List<MemberListResponseDto>> getMemberList() {
        List<MemberListResponseDto> members = memberService.getMemberList();
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

    @Operation(summary = "회원 정보 수정")
    @PutMapping("/{userId}")
    public ResponseEntity<MemberUpdateResponseDto> updateMember(@PathVariable Long userId, @RequestBody MemberUpdateRequestDto memberUpdateRequestDto) {
        MemberUpdateResponseDto member = memberService.updateMember(userId, memberUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

}
