package com.example.tarot.controller;

import com.example.tarot.entity.TarotCardEntity;
import com.example.tarot.entity.TarotHistoryEntity;
import com.example.tarot.service.TarotHistoryService;
import com.example.tarot.service.TarotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class TarotController {

    private final TarotService tarotService;
    private final TarotHistoryService historyService;

    public TarotController(
            TarotService tarotService,
            TarotHistoryService historyService
    ) {
        this.tarotService = tarotService;
        this.historyService = historyService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // 🔮 1장 타로
    @PostMapping("/draw")
    public String draw(
            @RequestParam(defaultValue = "today") String type,
            @RequestParam(required = false) String question,
            Model model,
            Principal principal
    ) {
        String username = principal.getName();

        TarotCardEntity tarotCard = tarotService.pickOne();
        String explanation =
                tarotService.buildSingleExplanation(tarotCard, type);

        historyService.saveSingle(
                question,
                tarotCard,
                explanation,
                type,
                username
        );

        model.addAttribute("tarotCard", tarotCard);
        model.addAttribute("explanation", explanation);
        model.addAttribute("type", type);
        model.addAttribute("question", question);

        return "result";
    }

    // 🔮 3장 타로
    @PostMapping("/draw3")
    public String draw3(
            @RequestParam(defaultValue = "today") String type,
            @RequestParam(required = false) String question,
            Model model,
            Principal principal
    ) {
        String username = principal.getName();

        List<TarotCardEntity> cards = tarotService.drawThree();
        List<String> explanations =
                tarotService.buildExplanations(cards, type);
        String summary =
                tarotService.buildSummary(cards, type);

        historyService.saveThree(
                question,
                cards,
                summary,
                type,
                username   // 🔥 여기 빠져있던 거 채움
        );

        model.addAttribute("cards", cards);
        model.addAttribute("explanations", explanations);
        model.addAttribute("summary", summary);
        model.addAttribute("type", type);
        model.addAttribute("question", question);

        return "draw3";
    }

    // 📜 히스토리 목록
    @GetMapping("/history")
    public String history(Model model, Principal principal) {

        String username = principal.getName();

        model.addAttribute(
                "histories",
                historyService.findByUsername(username)
        );

        return "history";
    }
    @PostMapping("/history/delete")
    public String deleteHistory(@RequestParam Long id) {
        historyService.deleteById(id);
        return "redirect:/history";
    }


    // 📜 히스토리 상세
    @GetMapping("/history/{id}")
    public String historyDetail(
            @PathVariable Long id,
            Model model
    ) {
        TarotHistoryEntity history =
                historyService.findById(id);

        model.addAttribute("history", history);
        return "history_detail";
    }

    // 💞 궁합 입력 페이지
    @GetMapping("/match")
    public String matchForm() {
        return "match";
    }

    // 💞 궁합 결과
    @GetMapping("/match/result")
    public String matchTarot(
            @RequestParam String nameA,
            @RequestParam String nameB,
            @RequestParam(required = false) String question,
            Model model,
            Principal principal
    ) {
        String username = principal.getName();

        List<TarotCardEntity> cards = tarotService.drawThree();
        List<String> explanations =
                tarotService.buildMatchExplanations(cards);
        String summary =
                tarotService.buildMatchSummary(cards, nameA, nameB);

        historyService.saveMatch(
                nameA,
                nameB,
                question,
                cards,
                summary,
                username   // 🔥 session → username
        );

        model.addAttribute("nameA", nameA);
        model.addAttribute("nameB", nameB);
        model.addAttribute("cards", cards);
        model.addAttribute("explanations", explanations);
        model.addAttribute("summary", summary);

        return "match_result";
    }
}