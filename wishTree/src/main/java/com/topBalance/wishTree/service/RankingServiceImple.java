package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.mapper.RankingMapper;
import com.topBalance.wishTree.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service // 이 클래스가 서비스 레이어 담당 Bean임을 스프링컨테이너에 알림. 비즈니스 로직처리 클래스
public class RankingServiceImple implements RankingService {

    @Autowired
    private RankingMapper rankingMapper;
    @Autowired
    private UserMapper user;

    @Override // 인터페이스의 메서드를 자식 클래스에서 재정의(Override)하고 있다
    public List<Map<String, Object>> getTenRank() {
        List<User> rankList = rankingMapper.getTenRank();
        return rankList.stream().map( user -> {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("userId", user.getUserId());
            userMap.put("totalScore", user.getTotalScore());

            return userMap;
        }).collect(Collectors.toList());
    }

    @Override
    public int selectRank(int total_score) {
        return rankingMapper.selectRank(total_score);
    }


}
