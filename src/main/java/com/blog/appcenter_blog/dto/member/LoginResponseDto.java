package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseDto {
    private String loginId;

    @Builder
    public LoginResponseDto(String loginId) {
        this.loginId = loginId;
    }

    public static LoginResponseDto from(MemberEntity member) {
        return LoginResponseDto.builder()
                .loginId(member.getLoginId())
                .build();
    }
}
