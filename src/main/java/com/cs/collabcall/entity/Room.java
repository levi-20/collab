package com.cs.collabcall.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;


    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
