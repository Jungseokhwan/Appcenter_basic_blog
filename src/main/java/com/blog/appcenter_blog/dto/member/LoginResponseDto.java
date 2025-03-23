package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginResponseDto {

    private final Long userId;

    private final String loginId;

    private final String nickname;

    @Builder
    public LoginResponseDto(Long userId, String loginId, String nickname) {
        this.userId = userId;
        this.loginId = loginId;
        this.nickname = nickname;
    }

    public static LoginResponseDto from(MemberEntity member) {
        return LoginResponseDto.builder()
                .userId(member.getUserId())
                .loginId(member.getLoginId())
                .nickname(member.getNickname())
                .build();
    }
}
