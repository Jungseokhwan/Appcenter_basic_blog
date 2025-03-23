package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberSignupResponseDto {

    private final Long userId;

    private final String password; //삭제 예정

    @Builder
    public MemberSignupResponseDto(Long userId, String password) {
        this.userId = userId;
        this.password = password; //삭제 예정
    }

    public static MemberSignupResponseDto from(MemberEntity member) {
        return MemberSignupResponseDto.builder()
                .userId(member.getUserId())
                .password(member.getPassword()) //삭제 예정
                .build();
    }
}
