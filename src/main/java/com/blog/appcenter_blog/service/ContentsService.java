package com.blog.appcenter_blog.service;

import com.blog.appcenter_blog.domain.entity.MemberEntity;
import com.blog.appcenter_blog.domain.entity.PostEntity;
import com.blog.appcenter_blog.domain.repository.MemberRepository;
import com.blog.appcenter_blog.domain.repository.PostRepository;
import com.blog.appcenter_blog.dto.post.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentsService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    //게시글 작성
    public PostCreateResponseDto savePost(Long userId, PostCreateRequestDto postCreateRequestDto) {
        MemberEntity member = memberRepository.findById(userId).orElseThrow();
        PostEntity postEntity = postRepository.save(postCreateRequestDto.toSave(member));
        return PostCreateResponseDto.from(postEntity);
    }

    //게시글 조회
    @Transactional
    public PostResponseDto getPost(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(
                () -> new RuntimeException("게시글을 찾을 수 없습니다.")
        );
        return PostResponseDto.from(postEntity);
    }

    //게시글 전체 조회
    @Transactional
    public List<PostListResponseDto> getPostList() {
        List<PostEntity> postEntitiyList = postRepository.findAll();
        List<PostListResponseDto> postListResponseDtoList = new ArrayList<>();
        for (PostEntity postEntity : postEntitiyList) {
            postListResponseDtoList.add(PostListResponseDto.from(postEntity));
        }
        return postListResponseDtoList;
    }

    //게시글 수정
    @Transactional
    public PostUpdateResponseDto updatePost(Long postId, PostUpdateRequestDto postUpdateRequestDto) {
        PostEntity existingPostEntity = postRepository.findById(postId).orElseThrow();
        PostEntity updatePostEntity = postRepository.save(existingPostEntity.updatePostEntity(postUpdateRequestDto.toSave(existingPostEntity.getMember())));
        return PostUpdateResponseDto.from(updatePostEntity);
    }

    //게시글 삭제
    public void deletePost(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow();
        postRepository.deleteById(postEntity.getPostId());
    }



}
