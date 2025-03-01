package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSignupRequestDto {

    private String loginId;

    private String password;

    private String nickname;

    public MemberEntity toSave() {
        return MemberEntity.builder()
                .loginId(loginId)
                .password(password)
                .nickname(nickname)
                .build();
    }

}
