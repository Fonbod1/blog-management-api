package com.blog.management.blog.management.Configuration;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // Custom OpenAPI metadata
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Blog MANAGEMENT API")
                        .description("This API manages the blog articles, allowing users to create, read, update, and delete articles.")
                        .version("1.0.0")
                );
    }

    // Only include endpoints under /api/articles/**
   /* @Bean
    public GroupedOpenApi articlesGroup() {
        return GroupedOpenApi.builder()
                .group("articles")
                .pathsToMatch("/api/articles/**")
                .build();
    }*/
}