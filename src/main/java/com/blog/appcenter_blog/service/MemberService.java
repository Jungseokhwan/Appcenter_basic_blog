package com.blog.appcenter_blog.service;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import com.blog.appcenter_blog.domain.repository.MemberRepository;
import com.blog.appcenter_blog.dto.member.*;
import com.blog.appcenter_blog.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.blog.appcenter_blog.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원 가입
    public MemberSignupResponseDto signupUser(MemberSignupRequestDto memberSignupRequestDto) {
        memberRepository.findByLoginId(memberSignupRequestDto.getLoginId())
                .ifPresent(existingMember -> {
                    throw new CustomException(DUPLICATE_LOGINID);
                });

        MemberEntity memberEntity = memberRepository.save(memberSignupRequestDto.toSave());// 실제 DB로 저장되는 부분
        return MemberSignupResponseDto.from(memberEntity);
    }

    //로그인
    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto) {
        MemberEntity memberEntity = memberRepository.findByLoginId(loginRequestDto.getLoginId()).orElseThrow(
                () -> new CustomException(NOT_EXIST_ID)
        );

        if (memberEntity.getPassword().equals(loginRequestDto.getPassword())) {
            return LoginResponseDto.from(memberEntity);
        }
        throw new CustomException(UNAUTHORIZED_LOGIN);
    }

    //회원 정보 조회
    public MemberResponseDto getMemberInfo(Long userId) {
        MemberEntity memberEntity = memberRepository.findById(userId).orElseThrow(
                () -> new CustomException(NOT_EXIST_ID)
        );
        return MemberResponseDto.from(memberEntity);
    }

    //전체 회원 정보 조회
    public List<MemberListResponseDto> getMemberList() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberListResponseDto> memberListResponseDtoList = new ArrayList<>();
        for (MemberEntity memberEntity : memberEntityList) {
            memberListResponseDtoList.add(MemberListResponseDto.from(memberEntity));
        }
        return memberListResponseDtoList;
    }

    //회원 정보 수정
    public MemberUpdateResponseDto updateMember(Long userId, MemberUpdateRequestDto memberUpdateRequestDto) {
        MemberEntity existingMemberInfo = memberRepository.findById(userId).orElseThrow(
                () -> new CustomException(NOT_EXIST_ID)
        );
        MemberEntity updateMemberInfo = memberRepository.save(existingMemberInfo.updateMemberEntity(memberUpdateRequestDto.toSave()));
        return MemberUpdateResponseDto.from(updateMemberInfo);
    }

}
