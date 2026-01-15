package com.example.tarot.controller;

import com.example.tarot.entity.TarotCardEntity;
import com.example.tarot.service.TarotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;



@Controller
public class TarotController {

    private final TarotService tarotService;

    public TarotController(TarotService tarotService) {
        this.tarotService = tarotService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/draw")
    public String draw(
            @RequestParam(defaultValue = "today") String type,
            Model model
    ) {
        TarotCardEntity tarotCard = tarotService.pickOne();
        String explanation =
                tarotService.buildSingleExplanation(tarotCard, type);


        model.addAttribute("tarotCard", tarotCard);
        model.addAttribute("explanation", explanation);
        model.addAttribute("type", type);

        return "result";
    }


    @GetMapping("/draw3")
    public String draw3(
            @RequestParam(defaultValue = "today") String type,
            Model model
    ) {
        List<TarotCardEntity> cards = tarotService.drawThree();
        List<String> explanations = tarotService.buildExplanations(cards, type);

        model.addAttribute("cards", cards);
        model.addAttribute("explanations", explanations);
        model.addAttribute("type", type);
        String summary = tarotService.buildSummary(cards, type);

        model.addAttribute("summary", summary);


        return "draw3";
    }

    }



