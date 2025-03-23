package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberSignupResponseDto {

    private final Long userId;

    private final String password;

    @Builder
    public MemberSignupResponseDto(Long userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public static MemberSignupResponseDto from(MemberEntity member) {
        return MemberSignupResponseDto.builder()
                .userId(member.getUserId())
                .password(member.getPassword())
                .build();
    }
}
