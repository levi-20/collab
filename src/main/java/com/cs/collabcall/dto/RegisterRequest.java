package com.cs.collabcall.dto;

public record RegisterRequest(
    String username,
    String email,
    String name,
    String password
) {
}
