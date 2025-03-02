package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    public MemberEntity toSave() {
        return MemberEntity.builder()
                .loginId(loginId)
                .password(password)
                .build();
    }

}
