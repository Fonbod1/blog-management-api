package com.blog.management.blog.management.Repository;

import com.blog.management.blog.management.Implementation.ArticleRepositoryCustom;
import com.blog.management.blog.management.Model.Article;
import com.blog.management.blog.management.Model.ArticleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface
ArticleRepository
        extends
        JpaRepository<Article, ArticleId>,
        ArticleRepositoryCustom {
    //find by id
    Optional<Article> findById(ArticleId id);
    //find all
    List<Article> findAll();
    //find by title
    List<Article> findByTitle(String title);
    //find by author
   // List<Article> findByAuthor(String author);
    //update

    // Custom query methods can be defined here if needed
    // For example, findByTitle, findByAuthor, etc.
}