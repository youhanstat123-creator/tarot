package com.example.tarot.service;

import com.example.tarot.entity.TarotCardEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TarotService {

    /* ===================== 카드 데이터 ===================== */

    private final List<TarotCardEntity> cards = List.of(

            new TarotCardEntity(
                    "The Fool", "fool.png",
                    "새로운 시작 · 자유 · 가능성",
                    "지금은 완벽함보다 시작 자체가 중요한 시기입니다.",
                    "부담 없이 첫걸음을 내딛어 보세요."
            ),

            new TarotCardEntity(
                    "The Magician", "magician.png",
                    "능력 · 실행력 · 주도권",
                    "당신이 가진 재능과 자원을 활용하기 좋은 때입니다.",
                    "계획만 하지 말고 행동으로 옮기세요."
            ),

            new TarotCardEntity(
                    "The High Priestess", "highpriestess.png",
                    "직관 · 비밀 · 내면",
                    "겉으로 보이지 않는 흐름이 중요한 역할을 합니다.",
                    "조급해하지 말고 직감을 믿으세요."
            ),

            new TarotCardEntity(
                    "The Empress", "empress.png",
                    "풍요 · 사랑 · 안정",
                    "주변 환경이 점점 안정되고 여유가 생깁니다.",
                    "받는 것뿐 아니라 나누는 마음을 가져보세요."
            ),

            new TarotCardEntity(
                    "The Emperor", "emperor.png",
                    "질서 · 책임 · 결단",
                    "감정보다 이성적인 판단이 필요한 시기입니다.",
                    "명확한 기준을 세우고 결정하세요."
            ),

            new TarotCardEntity(
                    "The Hierophant", "hierophant.png",
                    "전통 · 조언 · 배움",
                    "이미 검증된 방법이나 조언이 도움이 됩니다.",
                    "혼자 고민하지 말고 조언을 구하세요."
            ),

            new TarotCardEntity(
                    "The Lovers", "lovers.png",
                    "관계 · 선택 · 조화",
                    "중요한 선택의 순간에 서 있을 가능성이 큽니다.",
                    "마음이 향하는 방향을 솔직히 바라보세요."
            ),

            new TarotCardEntity(
                    "The Chariot", "chariot.png",
                    "전진 · 의지 · 승리",
                    "강한 의지를 가지고 밀고 나가면 성과가 있습니다.",
                    "주저하지 말고 목표를 향해 나아가세요."
            ),

            new TarotCardEntity(
                    "Strength", "strength.png",
                    "인내 · 내면의 힘 · 균형",
                    "겉으로 드러나는 힘보다 마음을 다스리는 것이 중요합니다.",
                    "서두르지 말고 자신을 믿으세요."
            ),

            new TarotCardEntity(
                    "The Hermit", "hermit.png",
                    "성찰 · 고독 · 탐색",
                    "잠시 멈춰 자신을 돌아볼 시간이 필요합니다.",
                    "답은 이미 당신 안에 있습니다."
            ),

            new TarotCardEntity(
                    "Wheel of Fortune", "wheel.png",
                    "변화 · 전환점 · 흐름",
                    "예상치 못한 변화가 찾아올 수 있습니다.",
                    "흐름에 유연하게 대응하세요."
            ),

            new TarotCardEntity(
                    "Justice", "justice.png",
                    "균형 · 공정 · 판단",
                    "모든 선택에는 책임이 따릅니다.",
                    "감정에 치우치지 말고 공정하게 판단하세요."
            ),

            new TarotCardEntity(
                    "The Hanged Man", "hangedman.png",
                    "관점 변화 · 기다림 · 희생",
                    "지금은 멈추고 다른 시각에서 바라볼 필요가 있습니다.",
                    "억지로 움직이기보다 시간을 허용하세요."
            ),

            new TarotCardEntity(
                    "Death", "death.png",
                    "끝 · 변화 · 재시작",
                    "어떤 흐름은 자연스럽게 마무리될 시점입니다.",
                    "끝을 받아들일수록 새로운 길이 열립니다."
            ),

            new TarotCardEntity(
                    "Temperance", "temperance.png",
                    "조화 · 절제 · 균형",
                    "극단보다는 중간 지점이 가장 안정적입니다.",
                    "차분하게 균형을 맞추세요."
            ),

            new TarotCardEntity(
                    "The Devil", "devil.png",
                    "집착 · 유혹 · 의존",
                    "불필요한 집착이 당신을 묶고 있을 수 있습니다.",
                    "스스로를 속박하는 요소를 내려놓으세요."
            ),

            new TarotCardEntity(
                    "The Tower", "tower.png",
                    "붕괴 · 각성 · 충격",
                    "예상치 못한 변화가 기존 질서를 흔들 수 있습니다.",
                    "무너진 자리에서 깨달음을 찾으세요."
            ),

            new TarotCardEntity(
                    "The Star", "star.png",
                    "희망 · 치유 · 회복",
                    "어두운 시간 뒤에 회복의 흐름이 시작됩니다.",
                    "희망을 놓지 마세요."
            ),

            new TarotCardEntity(
                    "The Moon", "moon.png",
                    "불안 · 환상 · 혼란",
                    "상황이 명확하지 않아 혼란스러울 수 있습니다.",
                    "사실과 감정을 구분하세요."
            ),

            new TarotCardEntity(
                    "The Sun", "sun.png",
                    "성공 · 기쁨 · 명확성",
                    "밝고 긍정적인 결과를 기대할 수 있습니다.",
                    "자신감을 가지고 즐기세요."
            ),

            new TarotCardEntity(
                    "Judgement", "judgement.png",
                    "결단 · 각성 · 새로운 단계",
                    "중요한 결정을 내려야 할 순간이 다가옵니다.",
                    "과거를 정리하고 앞으로 나아가세요."
            ),

            new TarotCardEntity(
                    "The World", "world.png",
                    "완성 · 성취 · 마무리",
                    "하나의 과정이 성공적으로 마무리됩니다.",
                    "스스로를 인정하고 다음 단계를 준비하세요."
            )
    );

    /* ===================== 카드 뽑기 ===================== */

    public TarotCardEntity pickOne() {
        List<TarotCardEntity> shuffled = new ArrayList<>(cards);
        Collections.shuffle(shuffled);
        return shuffled.get(0);
    }

    public List<TarotCardEntity> drawThree() {
        List<TarotCardEntity> shuffled = new ArrayList<>(cards);
        Collections.shuffle(shuffled);
        return shuffled.subList(0, 3);
    }

    /* ===================== 해석 출력 ===================== */

    public List<String> buildExplanations(List<TarotCardEntity> drawCards, String type) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < drawCards.size(); i++) {
            TarotCardEntity card = drawCards.get(i);
            String position = getPosition(drawCards.size(), i);

            String header = makeHeader(position, type);

            String body =
                    "【키워드】 " + card.getKeyword() + "\n\n" +
                            "【상황】 " + card.getSituation() + "\n\n" +
                            "【조언】 " + card.getAdvice();

            result.add(header + body);
        }
        return result;
    }

    public String buildSingleExplanation(TarotCardEntity card, String type) {
        return makeHeader("single", type) +
                "【키워드】 " + card.getKeyword() + "\n\n" +
                "【상황】 " + card.getSituation() + "\n\n" +
                "【조언】 " + card.getAdvice();
    }

    public String buildSummary(List<TarotCardEntity> cards, String type) {

        String topic = switch (type) {
            case "love" -> "연애의 흐름은 ";
            case "money" -> "금전 운의 흐름은 ";
            default -> "오늘 하루의 흐름은 ";
        };

        return topic +
                "과거(" + cards.get(0).getKeyword() + ") → " +
                "현재(" + cards.get(1).getKeyword() + ") → " +
                "미래(" + cards.get(2).getKeyword() + ")로 이어집니다.";
    }

    /* ===================== 내부 유틸 ===================== */

    private String getPosition(int size, int index) {
        if (size == 1) return "single";
        if (index == 0) return "past";
        if (index == 1) return "present";
        return "future";
    }

    private String makeHeader(String position, String type) {

        String time = switch (position) {
            case "past" -> "🕰 과거 ";
            case "present" -> "🌱 현재 ";
            case "future" -> "🌍 미래 ";
            default -> "";
        };

        String topic = switch (type) {
            case "love" -> "(연애)\n\n";
            case "money" -> "(금전)\n\n";
            default -> "(오늘)\n\n";
        };

        return time + topic;
    }
}
