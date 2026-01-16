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
    private String type;        // today / love / money
    private String cardNames;   // 카드 이름들

    @Column(length = 1000)
    private String summary;

    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String sessionId;   // 브라우저 식별자

    @Column(nullable = false)
    private String category;    // single / three / match

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
    public String getSessionId() { return sessionId; }
    public String getCategory() { return category; }

    // ===== Setter =====
    public void setQuestion(String question) { this.question = question; }
    public void setType(String type) { this.type = type; }
    public void setCardNames(String cardNames) { this.cardNames = cardNames; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }
    public void setCategory(String category) { this.category = category; }
}
