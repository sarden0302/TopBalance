package com.topBalance.wishTree.controller;

import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.service.BambooChattingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BambooController {

    @Autowired
    private BambooChattingService bambooChattingService;

    @GetMapping("/bamboo")
    public String bamboo(Model model, HttpSession session) {
        //Bamboo bamboos = new Bamboo();
        //bamboos.setCommentDate(bambooChattingService.test());
        List<Map<String, Object>> bamboos = bambooChattingService.getAllBambooChattings();
        model.addAttribute("bamboos", bamboos);
        //model.addAttribute("message", "Hello World");

        Object loggedInUser = addLoggedInUser(session);
        if (loggedInUser != null) {
            model.addAttribute("loggedInUser", loggedInUser);
        }
        return "bamboo";
    }

    @PostMapping("/insert-bamboo")
    public String bambooChange(@RequestParam("newbamboo") String newbamboo,
                               Model model,
                               HttpSession session) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            bambooChattingService.updatingBamboo((User)loggedInUser, newbamboo);
            return bamboo(model, session);
        }
        return "redirect:/bamboo";
    }

    @ModelAttribute("loggedInUser")
    public Object addLoggedInUser(HttpSession session) {
        return session.getAttribute("loggedInUser");
    }
}
