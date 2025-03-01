package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MemberListResponseDto {

    private String nickname;

    private String address;

    private LocalDate birth;

    private String phone;

    @Builder
    public MemberListResponseDto(String nickname, String address, LocalDate birth, String phone) {
        this.nickname = nickname;
        this.address = address;
        this.birth = birth;
        this.phone = phone;
    }

    public static MemberListResponseDto from(MemberEntity member) {
        return MemberListResponseDto.builder()
                .nickname(member.getNickname())
                .address(member.getAddress())
                .birth(member.getBirth())
                .phone(member.getPhone())
                .build();
    }
}
