
package com.blog.management.blog.management.Model;

import org.springframework.util.Assert;
//import.org.springframework.util.Assert;
import java.util.UUID;


//@Table(name = "article_id")
public record ArticleId(UUID id) {
    public  ArticleId {
        Assert.notNull(id, "id must not be null");
    }
    public static ArticleId create() {
        return new ArticleId(UUID.randomUUID());
    }
    // create a constructor
   // public ArticleId(UUID id) {
       // this.id = UUID.randomUUID();
  //  }

    public String asString() {
        return id.toString();
    }
}

