package com.blog.appcenter_blog.dto.post;

import com.blog.appcenter_blog.domain.entity.PostEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostListResponseDto {

    private String nickname;

    private String title;

    private String contents;

    @Builder
    public PostListResponseDto(String nickname, String title, String contents) {
        this.nickname = nickname;
        this.title = title;
        this.contents = contents;
    }

    public static PostListResponseDto from(PostEntity post) {
        return PostListResponseDto.builder()
                .nickname(post.getMember().getNickname())
                .title(post.getTitle())
                .contents(post.getContents())
                .build();
    }
}
