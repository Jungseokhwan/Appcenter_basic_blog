package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseDto {

    private Long userId;

    private String loginId;

    private String nickname;

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
