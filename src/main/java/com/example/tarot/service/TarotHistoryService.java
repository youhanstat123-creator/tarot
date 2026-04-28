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
            String username   // 🔥 변경
    ) {
        TarotHistoryEntity history = new TarotHistoryEntity();
        history.setQuestion(question);
        history.setType(type);
        history.setCardNames(card.getName());
        history.setSummary(explanation);
        history.setUsername(username);   // 🔥 변경
        history.setCategory("single");

        repository.save(history);
    }

    // 🔮 3장
    public void saveThree(
            String question,
            List<TarotCardEntity> cards,
            String summary,
            String type,
            String username   // 🔥 변경
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
        history.setUsername(username);   // 🔥 변경
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
            String username   // 🔥 변경
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
        history.setUsername(username);   // 🔥 변경
        history.setCategory("match");

        repository.save(history);
    }

    // 📜 조회 (🔥 핵심 변경)
    public List<TarotHistoryEntity> findByUsername(String username) {
        return repository.findByUsernameOrderByCreatedAtDesc(username);
    }

    public TarotHistoryEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("기록 없음"));
    }
}