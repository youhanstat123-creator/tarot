package com.example.tarot.repository;

import com.example.tarot.entity.TarotHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarotHistoryRepository
        extends JpaRepository<TarotHistoryEntity, Long> {

    List<TarotHistoryEntity>
    findBySessionIdOrderByCreatedAtDesc(String sessionId);
}
