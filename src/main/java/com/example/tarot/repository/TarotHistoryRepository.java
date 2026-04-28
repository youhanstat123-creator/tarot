package com.example.tarot.repository;

import com.example.tarot.entity.TarotHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarotHistoryRepository
        extends JpaRepository<TarotHistoryEntity, Long> {

    // ❌ 기존 (안 써도 됨)
    // List<TarotHistoryEntity> findBySessionIdOrderByCreatedAtDesc(String sessionId);

    // ✅ 새로 추가 (핵심)
    List<TarotHistoryEntity> findByUsernameOrderByCreatedAtDesc(String username);
}