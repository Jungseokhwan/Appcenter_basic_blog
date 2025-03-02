package com.blog.appcenter_blog.controller;

import com.blog.appcenter_blog.dto.post.*;
import com.blog.appcenter_blog.service.ContentsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/contents")
public class ContentsController {

    private final ContentsService contentsService;

    @Operation(summary = "게시글 작성")
    @PostMapping
    public ResponseEntity<PostCreateResponseDto> savePost(@RequestParam Long userId, @RequestBody PostCreateRequestDto postCreateRequestDto) {
        PostCreateResponseDto post = contentsService.savePost(userId, postCreateRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @Operation(summary = "게시글 조회")
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long postId) {
        PostResponseDto post = contentsService.getPost(postId);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @Operation(summary = "게시글 전체 조회")
    @GetMapping
    public ResponseEntity<List<PostListResponseDto>> getPostList() {
        List<PostListResponseDto> posts = contentsService.getPostList();
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @Operation(summary = "게시글 수정")
    @PutMapping("/{postId}")
    public ResponseEntity<PostUpdateResponseDto> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        PostUpdateResponseDto post = contentsService.updatePost(postId, postUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @Operation(summary = "게시글 삭제")
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        contentsService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}
