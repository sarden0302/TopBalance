package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.Bamboo;
import com.topBalance.wishTree.mapper.BambooChattingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BambooChattingServiceImpl implements BambooChattingService {

    @Autowired
    private BambooChattingMapper bambooChattingMapper;

    @Override
    public List<Map<String, Object>> getAllBambooChattings() {
        List<Bamboo> BambooList = bambooChattingMapper.getAllBamboos();
        return BambooList.stream().map(bamboo -> {
            Map<String, Object> bambooMap = new HashMap<>();
            bambooMap.put("userId", bamboo.getUserId());
            bambooMap.put("comment", bamboo.getComment());
            bambooMap.put("commentDate", bamboo.getCommentDate());
            return bambooMap;
        }).collect(Collectors.toList());
    }
}
