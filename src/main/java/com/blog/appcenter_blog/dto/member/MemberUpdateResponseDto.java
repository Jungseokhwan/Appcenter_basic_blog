package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateResponseDto {
    private String nickname;

    @Builder
    public MemberUpdateResponseDto(String nickname) {
        this.nickname = nickname;
    }

    public static MemberUpdateResponseDto from(MemberEntity member) {
        return MemberUpdateResponseDto.builder()
                .nickname(member.getNickname())
                .build();
    }
}
