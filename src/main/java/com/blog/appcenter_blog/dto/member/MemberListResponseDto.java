package com.blog.appcenter_blog.dto.member;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberListResponseDto {

    private final Long userId;

    private final String nickname;

    private final String address;

    private final LocalDate birth;

    private final String phone;

    @Builder
    public MemberListResponseDto(Long userId, String nickname, String address, LocalDate birth, String phone) {
        this.userId = userId;
        this.nickname = nickname;
        this.address = address;
        this.birth = birth;
        this.phone = phone;
    }

    public static MemberListResponseDto from(MemberEntity member) {
        return MemberListResponseDto.builder()
                .userId(member.getUserId())
                .nickname(member.getNickname())
                .address(member.getAddress())
                .birth(member.getBirth())
                .phone(member.getPhone())
                .build();
    }
}
