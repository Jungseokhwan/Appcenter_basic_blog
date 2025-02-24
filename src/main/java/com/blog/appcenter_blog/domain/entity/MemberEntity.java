package com.blog.appcenter_blog.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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

    // 회원과 게시글의 1:N 관계 설정
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostEntity> postList = new ArrayList<>();
}
