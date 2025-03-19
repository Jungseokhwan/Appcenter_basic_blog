package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MemberResponseDto {

    private Long userId;

    private String nickname;

    private String address;

    private LocalDate birth;

    private String phone;

    private String introduce;

    @Builder
    public MemberResponseDto(MemberEntity memberEntity) {
        this.userId = memberEntity.getUserId();
        this.nickname = memberEntity.getNickname();
        this.address = memberEntity.getAddress();
        this.birth = memberEntity.getBirth();
        this.phone = memberEntity.getPhone();
        this.introduce = memberEntity.getIntroduce();
    }

    public static MemberResponseDto from(MemberEntity member) {
        return MemberResponseDto.builder()
                .memberEntity(member)
                .build();
    }
}
