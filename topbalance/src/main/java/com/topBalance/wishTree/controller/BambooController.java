package com.topBalance.wishTree.controller;

import com.topBalance.wishTree.dto.BalanceQ;
import com.topBalance.wishTree.dto.Bamboo;
import com.topBalance.wishTree.service.BambooChattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class BambooController {

    @Autowired
    private BambooChattingService bambooChattingService;

    @GetMapping("/bamboo")
    public String bamboo(Model model) {
        //Bamboo bamboos = new Bamboo();
        //bamboos.setCommentDate(bambooChattingService.test());
        List<Map<String, Object>> bamboos = bambooChattingService.getAllBambooChattings();
        model.addAttribute("bamboos", bamboos);
        //model.addAttribute("message", "Hello World");
        return "bamboo";
    }

    @PostMapping("/bamboo-change")
    public String bambooChange(Model model, Bamboo bamboo) {

        return "bamboo";
    }
}
