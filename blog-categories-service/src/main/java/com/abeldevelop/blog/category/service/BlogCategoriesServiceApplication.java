package com.abeldevelop.blog.category.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan({"com.abeldevelop"})
@EntityScan("com.abeldevelop.blog.category.model")
@EnableJpaRepositories("com.abeldevelop.blog.category.repository")
@SpringBootApplication
public class BlogCategoriesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogCategoriesServiceApplication.class, args);
	}

}
