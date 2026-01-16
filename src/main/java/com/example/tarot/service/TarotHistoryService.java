package com.example.tarot.service;

import com.example.tarot.entity.TarotCardEntity;
import com.example.tarot.entity.TarotHistoryEntity;
import com.example.tarot.repository.TarotHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarotHistoryService {

    private final TarotHistoryRepository repository;

    public TarotHistoryService(TarotHistoryRepository repository) {
        this.repository = repository;
    }

    // 🔮 1장
    public void saveSingle(
            String question,
            TarotCardEntity card,
            String explanation,
            String type,
            String sessionId
    ) {
        TarotHistoryEntity history = new TarotHistoryEntity();
        history.setQuestion(question);
        history.setType(type);
        history.setCardNames(card.getName());
        history.setSummary(explanation);
        history.setSessionId(sessionId);
        history.setCategory("single");

        repository.save(history);
    }

    // 🔮 3장
    public void saveThree(
            String question,
            List<TarotCardEntity> cards,
            String summary,
            String type,
            String sessionId
    ) {
        TarotHistoryEntity history = new TarotHistoryEntity();
        history.setQuestion(question);
        history.setType(type);
        history.setCardNames(
                cards.stream()
                        .map(TarotCardEntity::getName)
                        .collect(Collectors.joining(", "))
        );
        history.setSummary(summary);
        history.setSessionId(sessionId);
        history.setCategory("three");

        repository.save(history);
    }

    // 💞 궁합
    public void saveMatch(
            String nameA,
            String nameB,
            String question,
            List<TarotCardEntity> cards,
            String summary,
            String sessionId
    ) {
        TarotHistoryEntity history = new TarotHistoryEntity();
        history.setQuestion(nameA + " ❤ " + nameB);
        history.setType("match");
        history.setCardNames(
                cards.stream()
                        .map(TarotCardEntity::getName)
                        .collect(Collectors.joining(", "))
        );
        history.setSummary(summary);
        history.setSessionId(sessionId);
        history.setCategory("match");

        repository.save(history);
    }

    // 📜 조회
    public List<TarotHistoryEntity> findBySession(String sessionId) {
        return repository.findBySessionIdOrderByCreatedAtDesc(sessionId);
    }

    public TarotHistoryEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("기록 없음"));
    }
}
