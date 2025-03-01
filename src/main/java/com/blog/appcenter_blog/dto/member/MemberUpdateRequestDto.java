package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {

    @NotBlank(message = "닉네임은 필수 입력 값 입니다.")
    private String nickname;

    private String address;

    private LocalDate birth;

    private String phone;

    private String introduce;

    public MemberEntity toSave() {
        return MemberEntity.builder()
                .nickname(nickname)
                .address(address)
                .birth(birth)
                .phone(phone)
                .introduce(introduce)
                .build();
    }
}
