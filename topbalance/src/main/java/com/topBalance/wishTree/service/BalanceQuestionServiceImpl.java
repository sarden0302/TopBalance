package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.BalanceQ;
import com.topBalance.wishTree.dto.CardType;
import com.topBalance.wishTree.mapper.BalanceQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BalanceQuestionServiceImpl implements BalanceQuestionService{

    @Autowired
    private BalanceQuestionMapper balanceQuestionMapper;

    @Override
    public List<Map<String, Object>> getAllBalanceQuestion() {
        List<BalanceQ> balanceQList = balanceQuestionMapper.getAllBalanceQs();
        return balanceQList.stream().map(balanceQ -> {
            Map<String, Object> balanceQMap = new HashMap<>();
            balanceQMap.put("index", balanceQ.getIndex());
            balanceQMap.put("questionNumber", balanceQ.getQuestionNumber());
            balanceQMap.put("answerLeft", balanceQ.getAnswerLeft());
            balanceQMap.put("scoreS", balanceQ.getScoreS());
            balanceQMap.put("scoreC", balanceQ.getScoreC());
            balanceQMap.put("scoreH", balanceQ.getScoreH());
            balanceQMap.put("scoreD", balanceQ.getScoreD());
            balanceQMap.put("problem", balanceQ.getProblem());
            balanceQMap.put("answer", balanceQ.getAnswer());
            return balanceQMap;
        }).collect(Collectors.toList());

    }
}
