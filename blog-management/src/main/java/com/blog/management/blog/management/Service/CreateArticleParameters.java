package com.blog.management.blog.management.Service;

import java.time.LocalDateTime;

public record CreateArticleParameters(
        String title,
        String content,
        LocalDateTime publisher_date

) {
}
