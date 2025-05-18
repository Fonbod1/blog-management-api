package com.blog.management.blog.management.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "article")
@Data // Lombok generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok generates the default no-args constructor
@AllArgsConstructor // Lombok generates the constructor with all arguments
//@Access(AccessType.FIELD) // JPA will use fields directly instead of getter/setter methods
public class Article {

  @EmbeddedId
  @AttributeOverride(name = "id", column = @Column(name = "id"))
  private ArticleId id; // Composite primary key

  @NotNull
  @Column(name = "title")
  private String title;

  @NotNull
  @Column(name = "content", columnDefinition = "TEXT")
  private String content;

  @NotNull
  @Column(name = "published_date")
  private LocalDateTime published_date;

  @Version
  @Column(name = "version")
  private Long version; // Optimistic locking field

   //Constructor with parameters
  public Article(ArticleId id, String title, String content, LocalDateTime published_date) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.published_date = published_date;
  }

  public ArticleId getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public LocalDateTime getPublished_date() {
    return published_date;
  }

  public Long getVersion() {
    return version;
  }

  public void setId(ArticleId id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setPublished_date(LocalDateTime published_date) {
    this.published_date = published_date;
  }

  public void setVersion(Long version) {
    this.version = version;
  }
//public @NotNull String setTitle(String title) {
   ///   return this.title= title;
  //}

  //public @NotNull String setContent(String content) {
    //   return this.content = content;

  //}
}




/*
package com.blog.management.blog.management.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

// persist in the database
@Entity(name = "Article")
@Table(name = "article")
@Data
@AllArgsConstructor
public class Article {
  //to create a seperate class for the ID to aviod duplicate values
    @ManyToOne
    @JoinColumn(name = "id_id")
    @EmbeddedId
    @AttributeOverride(
            name = "id",
            column = @Column(name = "id")

    )
    private ArticleId id;

    @NotNull
  private String title;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime publishedDate;

    @Version
    private Long version;

    // Default constructor
    public Article() {

    }
    // Constructor with parameters
    public Article(ArticleId id, String title, String content, LocalDateTime publishedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publishedDate = publishedDate;
    }

  //public Article(ArticleId articleId, String title, String content) {

  //}

  public ArticleId getId() {
    return id;
  }

  //public void setId(ArticleId id) {
    //this.id = id;
  //}

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public @NotNull LocalDateTime getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(@NotNull LocalDateTime publishedDate) {
    this.publishedDate = publishedDate;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String toString() {
    return "Article{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", publishedDate='" + publishedDate + '\'' +
            ", version=" + version +
            '}';
  }
}
*/