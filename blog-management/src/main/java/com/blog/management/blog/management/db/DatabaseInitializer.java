package com.blog.management.blog.management.db;

import com.blog.management.blog.management.Model.Article;
import com.blog.management.blog.management.Service.ArticleService;
import com.blog.management.blog.management.Service.CreateArticleParameters;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@Profile("init-db")
public class DatabaseInitializer implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseInitializer.class);

    private final ArticleService articleService;
    private final Faker faker;
    private final Random random;

    // Constructor injection for ArticleService and Faker
    public DatabaseInitializer(ArticleService articleService, Faker faker) {
        this.articleService = articleService;
        this.faker = faker;
        this.random = new Random();
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Initializing database with dummy data...");

        for (int i = 1; i <= 30; i++) {
            CreateArticleParameters parameters = generateRandomCreateArticleParameters();
            Article article = articleService.createArticle(parameters);
            // Defensive: avoid NPE if article is null
            if (article != null) {
                LOGGER.info("Created article with ID: {}, Title: {}",
                        article.getId() != null ? article.getId().toString() : "null",
                        article.getTitle());
            } else {
                LOGGER.warn("Article creation returned null for parameters: {}", parameters);
            }
        }

        LOGGER.info("Database initialization completed (✓)");
    }

    private CreateArticleParameters generateRandomCreateArticleParameters() {
        return new CreateArticleParameters(
                generateRandomArticleTitle(),
                generateRandomArticleContent(),
                generateRandomArticlePublisherDate().atStartOfDay() // Converts LocalDate to LocalDateTime
        );
    }

    private String generateRandomArticleTitle() {
        return faker.book().title();
    }

    private String generateRandomArticleContent() {
        String paragraph = faker.lorem().paragraph(random.nextInt(5, 10));
        return Arrays.stream(paragraph.split("\\. "))
                .reduce("", (a, b) -> a + "\n " + b);
    }

    private LocalDate generateRandomArticlePublisherDate() {
        java.util.Date date = faker.date().past(1500, TimeUnit.DAYS);
        return LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
    }
}