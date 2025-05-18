package com.blog.management.blog.management.db;

import java.util.UUID;

public interface UniqueIdGenerator {
    UUID getNextUniqueId();
}
