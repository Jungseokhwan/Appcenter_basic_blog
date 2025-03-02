package com.blog.appcenter_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AppcenterBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppcenterBlogApplication.class, args);
    }

}
