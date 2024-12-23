package com.topBalance.wishTree.controller;

import com.topBalance.wishTree.service.BalanceQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class BalanceGameController {

    @Autowired
    private BalanceQuestionService balanceQuestionService;

    @GetMapping("/balancegame")
    public String balanceGame(Model model) {
        List<Map<String, Object>> balances = balanceQuestionService.getAllBalanceQuestion();
        model.addAttribute("balances", balances);
        //model.addAttribute("message", "Hello World");
        return "balancegame";
    }
}
