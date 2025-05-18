package com.blog.management.blog.management.Controller;

import com.blog.management.blog.management.Model.Article;
import com.blog.management.blog.management.Model.ArticleId;
import com.blog.management.blog.management.Service.ArticleService;
import com.blog.management.blog.management.Service.CreateArticleParameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@Tag(name = "Article Management", description = "Operations related to article management")

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // Create a new article
    @Tag(name = "Create Article", description = "Create a new article")
    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<Article> createArticle(@RequestBody CreateArticleParameters params) {
        Article created = articleService.createArticle(params);
        return ResponseEntity.ok(created);
    }

    // Get all articles
    @Tag(name = "Get All Articles", description = "Retrieve all articles")
    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    // Get article by ID
    @Tag(name = "Get Article by ID", description = "Retrieve an article by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable String id) {
        ArticleId articleId = new ArticleId(UUID.fromString(id));
        return ResponseEntity.ok(articleService.getArticleById(articleId));
    }

    // Update article (title/content)
    @Tag(name = "Update Article", description = "Update an existing article")
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(
            @PathVariable String id,
            @RequestBody UpdateArticleRequest request) {
        ArticleId articleId = new ArticleId(UUID.fromString(id));
        Article updated = articleService.updateArticle(articleId, request.title(), request.content());
        return ResponseEntity.ok(updated);
    }

    // Delete article
    @Tag(name = "Delete Article", description = "Delete an article by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable String id) {
        ArticleId articleId = new ArticleId(UUID.fromString(id));
        articleService.deleteArticle(articleId);
        return ResponseEntity.noContent().build();
    }

    // DTO for update request
    public record UpdateArticleRequest(String title, String content) {}

}
//}
