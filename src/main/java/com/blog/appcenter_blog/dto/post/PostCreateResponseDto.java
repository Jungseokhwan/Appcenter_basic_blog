package com.blog.appcenter_blog.dto.post;

import com.blog.appcenter_blog.domain.entity.PostEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateResponseDto {

    private Long postId;

    @Builder
    public PostCreateResponseDto(Long postId) {
        this.postId = postId;
    }

    public static PostCreateResponseDto from(PostEntity post) {
        return PostCreateResponseDto.builder()
                .postId(post.getPostId())
                .build();
    }
}
