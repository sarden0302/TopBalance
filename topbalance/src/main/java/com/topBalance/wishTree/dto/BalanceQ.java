package com.topBalance.wishTree.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BalanceQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index;
    private int questionNumber;
    private boolean answerLeft;
    private int scoreS;
    private int scoreC;
    private int scoreH;
    private int scoreD;
    private String problem;
    private String answer;

    public boolean getAnswerLeft() {
        return answerLeft;
    }

    public void setAnswerLeft(boolean answerLeft) {
        this.answerLeft = answerLeft;
    }
}
