package com.blog.appcenter_blog.dto.post;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import com.blog.appcenter_blog.domain.entity.PostEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreateRequestDto {

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "글을 작성해주세요.")
    private String contents;

    @NotNull
    private Boolean main;

    public PostEntity toSave(MemberEntity member) {
        return PostEntity.builder()
                .member(member)
                .title(title)
                .contents(contents)
                .main(main)
                .build();
    }
}
