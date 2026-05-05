package com.cs.collabcall.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(

    UUID id,
    String username,
    String email,
    String name,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
