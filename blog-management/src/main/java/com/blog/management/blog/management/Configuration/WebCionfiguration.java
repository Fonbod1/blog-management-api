package com.blog.management.blog.management.Configuration;

import com.blog.management.blog.management.db.InMemoryUniqueIdGeneratorImpl;
import com.blog.management.blog.management.db.UniqueIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebCionfiguration {
    // This class is used to configure the web application
    // It can be used to configure the web application context, view resolvers, etc.
    @Bean
    public UniqueIdGenerator uniqueIdGenerator() {
        // This method is used to create a unique ID generator
        // It can be used to generate unique IDs for the articles
        return new InMemoryUniqueIdGeneratorImpl();
    }
}
