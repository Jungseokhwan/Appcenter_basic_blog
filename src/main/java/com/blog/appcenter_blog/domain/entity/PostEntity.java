package com.blog.appcenter_blog.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "post_table")
public class PostEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Column(nullable = false)
    private boolean isMain;

    // 작성자(회원)와의 다대일(N:1) 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId") // FK
    private MemberEntity member;

    @Builder
    public PostEntity(String title, String contents, boolean isMain, MemberEntity member) {
        this.title = title;
        this.contents = contents;
        this.isMain = isMain;
        this.member = member;
    }

    public PostEntity updatePostEntity(PostEntity postEntity) {
        this.title = postEntity.getTitle();
        this.contents = postEntity.getContents();
        this.isMain = postEntity.isMain();
        return this;
    }
}
