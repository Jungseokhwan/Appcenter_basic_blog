package com.blog.appcenter_blog.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor
@Table(name = "member_table")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long userId;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String nickname;

    @Column
    private String address;

    //이렇게 받는게 맞는지 모르겠음
    @Column
    private LocalDate birth;

    @Column(length = 15)
    private String phone;

    @Column(length = 1000)
    private String introduce;

    @Builder
    public MemberEntity(String loginId, String password, String nickname, String address, LocalDate birth, String phone, String introduce) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.address = address;
        this.birth = birth;
        this.phone = phone;
        this.introduce = introduce;
    }

//    이렇게 해도 되나? 질문
    public MemberEntity updateMemberEntity(MemberEntity memberEntity){
        this.nickname = memberEntity.getNickname();
        this.address = memberEntity.getAddress();
        this.birth = memberEntity.getBirth();
        this.phone = memberEntity.getPhone();
        this.introduce = memberEntity.getIntroduce();
        return this;
    }
}
