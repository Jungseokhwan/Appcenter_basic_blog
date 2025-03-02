package com.blog.appcenter_blog.dto.post;

import com.blog.appcenter_blog.domain.entity.PostEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResponseDto {

    private String nickname;

    private String title;

    private String contents;

    private boolean isMain;

    @Builder
    public PostResponseDto(String nickname, String title, String contents, boolean isMain) {
        this.nickname = nickname;
        this.title = title;
        this.contents = contents;
        this.isMain = isMain;
    }

    public static PostResponseDto from(PostEntity post) {
        return PostResponseDto.builder()
                .nickname(post.getMember().getNickname())
                .title(post.getTitle())
                .contents(post.getContents())
                .isMain(post.isMain())
                .build();
    }
}
