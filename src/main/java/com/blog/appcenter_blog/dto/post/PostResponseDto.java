package com.blog.appcenter_blog.dto.post;

import com.blog.appcenter_blog.domain.entity.PostEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class PostResponseDto {

    private final String nickname;

    private final String title;

    private final String contents;

    private final Boolean isMain;

    private final LocalDate postTime;

    @Builder
    public PostResponseDto(String nickname, String title, String contents, Boolean isMain, LocalDate postTime) {
        this.nickname = nickname;
        this.title = title;
        this.contents = contents;
        this.isMain = isMain;
        this.postTime = postTime;

    }

    public static PostResponseDto from(PostEntity post) {
        LocalDateTime localDateTime = post.getUpdateAt();
        LocalDate localDate = localDateTime.toLocalDate();

        return PostResponseDto.builder()
                .nickname(post.getMember().getNickname())
                .title(post.getTitle())
                .contents(post.getContents())
                .isMain(post.getMain())
                .postTime(localDate)
                .build();
    }
}
