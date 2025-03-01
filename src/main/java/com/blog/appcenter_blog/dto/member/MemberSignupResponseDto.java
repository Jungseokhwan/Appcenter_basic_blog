package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignupResponseDto {
    private Long userId;

    @Builder
    public MemberSignupResponseDto(Long userId) {
        this.userId = userId;
    }

    public static MemberSignupResponseDto from(MemberEntity member) {
        return MemberSignupResponseDto.builder()
                .userId(member.getUserId())
                .build();
    }
}
