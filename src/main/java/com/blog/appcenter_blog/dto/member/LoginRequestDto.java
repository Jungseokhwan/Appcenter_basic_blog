package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    private String loginId;

    private String password;

    public MemberEntity toSave() {
        return MemberEntity.builder()
                .loginId(loginId)
                .password(password)
                .build();
    }

}
