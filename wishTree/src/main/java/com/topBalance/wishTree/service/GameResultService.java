package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.CardType;
import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.vo.GameScores;

import java.util.Map;

public interface GameResultService {

    //행운 총 점수 더한 total score
    int totalScore(GameScores gameScores);

    // 트럼프 카드 경로 가져노기
    Map<String, Object> balanceTrump(GameScores gameScores);

    // 오늘의 추천메뉴 사진+메뉴(lunchResult)출력
    String todaysLunch(CardType lunchMax, CardType lunchMin);

    // 게임 점수를 카드 점수로 변환하는 메서드
    int getChangingNumber(int cardNumber);

    // 변환한 카드 점수를 저장
    void changingCardNumber(GameScores gameScores);

    //게임 결과로 저장된 4가지 운세별 점수를 한번에 4가지 모두 가져오기 위해 Map으로 저장
    Map<String, Object> getOldCardScores(GameScores gameScores);

    // 오늘의 운세 한문장 (건강, 연애, 재물, 학업)
    Map<String, Object> getCategoryResult(GameScores gameScores);

    //게임 결과 점수중 max값 구하기
    CardType getMaxCategory(GameScores gameScores);

    //게임 결과 점수 중 min 값 구하기
    CardType getMinCategory(GameScores gameScores);

    // 구해진 max,min값에 해당하는 이미지 출력하기
    String getTodaysLunchPath(CardType MAX, CardType MIN);

    void updatingTotalScore(User loggedInUser, int totalScore);
}
