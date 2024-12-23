package com.topBalance.wishTree.controller;

import com.topBalance.wishTree.service.BambooChattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class BambooController {

    @Autowired
    private BambooChattingService bambooChattingService;

    @GetMapping("/bamboo.html")
    public String bamboo(Model model) {
        List<Map<String, Object>> bamboos = bambooChattingService.getAllBambooChattings();
        model.addAttribute("bamboos", bamboos);
        //model.addAttribute("message", "Hello World");
        return "bamboo";
    }
}
