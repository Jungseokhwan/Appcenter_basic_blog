package com.blog.appcenter_blog.domain.repository;

import com.blog.appcenter_blog.domain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findAllByMember_UserId(Long userId);


}
