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

@Service
public class RankingServiceImple implements RankingService {

    @Autowired
    private RankingMapper rankingMapper;
    @Autowired
    private UserMapper user;

    @Override
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