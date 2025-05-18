
package com.blog.management.blog.management.Service;

import com.blog.management.blog.management.Model.Article;
import com.blog.management.blog.management.Model.ArticleId;
import com.blog.management.blog.management.Repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // Method to create a new article
    public Article createArticle(CreateArticleParameters parameters) {
        // Generate a new ArticleId using UUID
        ArticleId articleId = ArticleId.create();

        // Create the article object with the generated article ID
        Article article = new Article(
                articleId,
                parameters.title(),
                parameters.content(),
                parameters.publisher_date()
        );

        // Save and return the article
        return articleRepository.save(article);
    }

    // Method to update an existing article
    public Article updateArticle(ArticleId id, String title, String content) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        article.setTitle(title);
        article.setContent(content);
        return articleRepository.save(article);
    }

    // Method to delete an article by its ID
    public void deleteArticle(ArticleId id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        articleRepository.delete(article);
    }

    // Method to get an article by its ID
    public Article getArticleById(ArticleId id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    // Method to get all articles
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // No need for a generateNextArticleId() method anymore!
}

/*

package com.blog.management.blog.management.Service;

import com.blog.management.blog.management.Model.Article;
import com.blog.management.blog.management.Model.ArticleId;
import com.blog.management.blog.management.Repository.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticleService {

    // Dependency injection for the ArticleRepository (constructor injection)
    private final ArticleRepository articleRepository;

    // Constructor to inject dependencies
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // Method to create a new article
    public Article createArticle(CreateArticleParameters parameters) {
        // Get the article ID using the custom method from the repository
       ArticleId articleId = this.articleRepository.nextId();

        // Create a new article object with the generated article ID
        Article article = new Article(
                articleId,
                parameters.title(),
                parameters.content(),
                parameters.publisher_date()
        );

        // Save the article to the database
        return articleRepository.save(article);
    }

    // Method to update an existing article
    public Article updateArticle(ArticleId id, String title, String content) {
        // Find the article by ID
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        // Update the article's title and content
        article.setTitle(title);  // Using Lombok's setter
        article.setContent(content);  // Using Lombok's setter

        // Save the updated article to the database
        return articleRepository.save(article);
    }

    // Method to delete an article by its ID
    public void deleteArticle(ArticleId id) {
        // Find the article by ID
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        // Delete the article from the database
        articleRepository.delete(article);
    }

    // Method to get an article by its ID
    public Article getArticleById(ArticleId id) {
        // Find the article by ID
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    // Method to get all articles
    public List<Article> getAllArticles() {
        // Fetch all articles from the database
        return articleRepository.findAll();
    }

    // Method to generate the next article ID
    public ArticleId generateNextArticleId() {
        return articleRepository.nextId(); // Use the custom method from the repository
    }
}
*/