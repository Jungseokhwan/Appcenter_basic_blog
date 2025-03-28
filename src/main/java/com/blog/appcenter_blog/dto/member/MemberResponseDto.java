package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberResponseDto {

    private final String nickname;

    private final String address;

    private final LocalDate birth;

    private final String phone;

    private final String introduce;

    @Builder
    public MemberResponseDto(MemberEntity memberEntity) {
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
