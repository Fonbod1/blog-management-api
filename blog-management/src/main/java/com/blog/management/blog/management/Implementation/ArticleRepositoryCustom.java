package com.blog.management.blog.management.Implementation;

import com.blog.management.blog.management.Model.ArticleId;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepositoryCustom {
   // @Query("SELECT MAX(a.id) FROM Article a")
    //ArticleId nextId();
}
