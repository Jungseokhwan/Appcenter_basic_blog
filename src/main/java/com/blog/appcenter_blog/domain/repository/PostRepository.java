package com.blog.appcenter_blog.domain.repository;

import com.blog.appcenter_blog.domain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
