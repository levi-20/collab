package com.cs.collabcall.dto;

import java.util.UUID;

public record UpdateUserRequest(
    UUID id,
    String email,
    String name
) {
}
