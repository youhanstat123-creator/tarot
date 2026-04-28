package com.example.tarot.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarot_history")
public class TarotHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String type;
    private String cardNames;

    @Column(length = 1000)
    private String summary;

    private LocalDateTime createdAt;

    // 🔥 변경 핵심
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String category;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== Getter =====
    public Long getId() { return id; }
    public String getQuestion() { return question; }
    public String getType() { return type; }
    public String getCardNames() { return cardNames; }
    public String getSummary() { return summary; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getUsername() { return username; }   // 🔥 추가
    public String getCategory() { return category; }

    // ===== Setter =====
    public void setQuestion(String question) { this.question = question; }
    public void setType(String type) { this.type = type; }
    public void setCardNames(String cardNames) { this.cardNames = cardNames; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setUsername(String username) { this.username = username; } // 🔥 추가
    public void setCategory(String category) { this.category = category; }
}