package com.topBalance.wishTree.service;

import java.util.List;
import java.util.Map;

    // 자바에서 사용할 기능의 목록만 작성
public interface RankingService {
    // service로 사용할 기능 설정

    // html로 서비스 기능을 통해 나타난 결과를 보여줄 기능들 작성

    // 상위 랭크 10명 보기 기능
    List<Map<String, Object>> getTenRank();

    int selectRank(int total_score);
}
