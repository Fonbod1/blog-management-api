package com.blog.management.blog.management.db;

import org.springframework.stereotype.Component;

import java.util.UUID;
@Component

public class InMemoryUniqueIdGeneratorImpl implements UniqueIdGenerator {
    //private long currentId = 0;

    @Override
    public UUID getNextUniqueId() {
        return UUID.randomUUID();
    }

    // Optionally, you can add a method to reset the ID generator for testing purposes

}
