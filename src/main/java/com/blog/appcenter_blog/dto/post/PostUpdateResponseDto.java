package com.blog.appcenter_blog.dto.post;

import com.blog.appcenter_blog.domain.entity.PostEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostUpdateResponseDto {

    private final Long postId;

    @Builder
    public PostUpdateResponseDto(Long postId) {
        this.postId = postId;
    }

    public static PostUpdateResponseDto from(PostEntity post) {
        return PostUpdateResponseDto.builder()
                .postId(post.getPostId())
                .build();
    }
}
