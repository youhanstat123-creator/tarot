package com.example.tarot.entity;

public class TarotCardEntity {

    private String name;
    private String image;
    private String keyword;   // 기존 meaning 대체
    private String situation; // 상황 설명
    private String advice;    // 조언

    public TarotCardEntity(
            String name,
            String image,
            String keyword,
            String situation,
            String advice
    ) {
        this.name = name;
        this.image = image;
        this.keyword = keyword;
        this.situation = situation;
        this.advice = advice;
    }

    public String getName() { return name; }
    public String getImage() { return image; }
    public String getKeyword() { return keyword; }
    public String getSituation() { return situation; }
    public String getAdvice() { return advice; }
}
