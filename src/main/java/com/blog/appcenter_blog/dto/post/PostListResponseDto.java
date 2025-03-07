package com.blog.appcenter_blog.dto.post;

import com.blog.appcenter_blog.domain.entity.PostEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostListResponseDto {

    private String nickname;

    private String title;

    private String contents;

    private LocalDate postTime;

    @Builder
    public PostListResponseDto(String nickname, String title, String contents, LocalDate postTime) {
        this.nickname = nickname;
        this.title = title;
        this.contents = contents;
        this.postTime = postTime;
    }

    public static PostListResponseDto from(PostEntity post) {
        LocalDateTime localDateTime = post.getUpdateAt();
        LocalDate localDate = localDateTime.toLocalDate();

        return PostListResponseDto.builder()
                .nickname(post.getMember().getNickname())
                .title(post.getTitle())
                .contents(post.getContents())
                .postTime(localDate)
                .build();
    }
}
