-- File: V1__Create_article_table.sql
CREATE TABLE article (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    published_date TIMESTAMP NOT NULL,
    version BIGINT NOT NULL
);