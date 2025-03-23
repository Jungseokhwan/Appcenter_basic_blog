package com.blog.appcenter_blog.dto.post;

import com.blog.appcenter_blog.domain.entity.PostEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {

    private final Long postId;

    private final String nickname;

    private final String title;

    private final String contents;

    private final LocalDate postTime;

    @Builder
    public PostListResponseDto(Long postId, String nickname, String title, String contents, LocalDate postTime) {
        this.postId = postId;
        this.nickname = nickname;
        this.title = title;
        this.contents = contents;
        this.postTime = postTime;
    }

    public static PostListResponseDto from(PostEntity post) {
        LocalDateTime localDateTime = post.getUpdateAt();
        LocalDate localDate = localDateTime.toLocalDate();

        return PostListResponseDto.builder()
                .postId(post.getPostId())
                .nickname(post.getMember().getNickname())
                .title(post.getTitle())
                .contents(post.getContents())
                .postTime(localDate)
                .build();
    }

}
