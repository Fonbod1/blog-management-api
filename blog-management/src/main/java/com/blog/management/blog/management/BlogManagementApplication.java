package com.blog.management.blog.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.blog.management.blog.management.Repository")
public class BlogManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogManagementApplication.class, args);
	}
}