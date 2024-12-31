package com.topBalance.wishTree.controller;

import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.service.RankingService;
import com.topBalance.wishTree.service.UserService;
import com.topBalance.wishTree.service.WishService;
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
import java.util.Date;


@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private RankingService rankingService;
    @Autowired
    private WishService wishService;

    @GetMapping("/") // - 엔드포인트 html 파일에 작성한 화면을 보여줄 주소
    public String ranksindex(Model model) { // model은 index.html에 자바로 작성한 값을 전달할 변수
        List<Map<String, Object>> ranks = rankingService.getTenRank();
        System.out.println("ranks 목록 확인  : " + ranks);
        model.addAttribute("ranks", ranks);

        List<Map<String, Object>> wishs = wishService.getSevenWish();
        System.out.println("wishs 목록 확인  : " + wishs);
        model.addAttribute("wishs", wishs);
        //model.addAttribute("message", "Hello World");
        return "index";
    }

    // DB에 값을 집어넣을 때는 PostMapping 사용하고 엔드포인트 form action에서 작성한 주소를 엔드포인트로 지정
    @PostMapping("/selectranks-success")
    public String selectSuccess(@ModelAttribute("ranks") User user, Model model) {

        model.addAttribute("msg", "랭킹 조회완료");
        return "success";
    }
    @PostMapping("/selectwishs-success")
    public String registerSuccessed(@ModelAttribute("wishs") User user, Model model) {

        model.addAttribute("msg", "한해소망 조회완료");
        return "success"; //회원가입이 무사히 완료될 경우 success 페이지로 이동
    }

    //회원 가입
    @GetMapping("/register")
    public String register() {

        return "register";
    }

    //가입 성공 페이지
    @PostMapping("/register-success")
    public String registerSuccess(@ModelAttribute("user") User user, Model model) {
        userService.insertUser(user);
        model.addAttribute("msg", "회원가입이 성공적으로 완료되었습니다.");
        return "register-success";
    }

    /**
     * 로그인
     *
     * @return
     */
    @GetMapping("login")
    public String login() {
        return "login";
    }

    /**
     * 로그인체크
     *
     * @param userId
     * @param userPassword
     * @param model
     * @return
     */
    @PostMapping("login")
    public String login(@RequestParam String userId,
                        @RequestParam String userPassword,
                        Model model,
                        HttpSession session) {
        User user = userService.login(userId, userPassword);

        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/";
        }
        else {
            model.addAttribute("fail","아이디나 비밀번호가 일치하지 않습니다.");
            return "login";
        }
    }
    @ModelAttribute("loggedInUser")
    public Object addLoggedInUser(HttpSession session) {
        return session.getAttribute("loggedInUser");
    }

    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        session.invalidate();
        session.getAttribute("loggedOutUser");
        return "redirect:/";
    }

    @GetMapping("/mypage")
    public String myPage(Model model, HttpSession session) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);
            return "mypage";
        } else {
            return "redirect:/login";
        }
    }

    //회원정보 수정 작성페이지
    @GetMapping("/update")
    public String update(Model model, HttpSession session) {
        Object loggedInUser = session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            model.addAttribute("user", loggedInUser);
            return "/update";
        } else {
            return "redirect:/login";
        }

    }
    /*public String updateUser(@PathVariable String userId, Model model) {
        User user = userService.updateUser(userId);
        model.addAttribute("user", user);
        return "update";
    }*/
    @PostMapping("/update-success")
    public String updateSuccess(@ModelAttribute("user") User user, Model model, HttpSession session) {
        userService.updateUser(user);

        // DB Latest information
        User updateUser = userService.findUserById(user.getUserId());

        //Session Latest information
        session.setAttribute("loggedInUser", updateUser);
        model.addAttribute("msg", "정보수정이 성공적으로 완료되었습니다.");
        return "redirect:/mypage";
    }

    @GetMapping("/find-password")
    public String findByPassword() {

        return "find-password";
    }


    @GetMapping("/find-password-result")
    public String findByPassword(@RequestParam String userId,
                                 @RequestParam String userPhone,
                                 Model model) {
        String password = userService.findByPassword(userId, userPhone);
        model.addAttribute("password", password);
        return "find-password-result";
    }

    @GetMapping("/find-id")
    public String findById(String userName, String userPhone, Date userBirthdate) {
        return "find-id";
    }

    @GetMapping("/find-id-result")
    public String findById(@RequestParam String userName,
                           @RequestParam String userPhone,
                           @RequestParam Date userBirthdate,
                           Model model) {
        String findID = userService.findById(userName, userPhone, userBirthdate);
        model.addAttribute("userId", findID);
        return "find-id-result";
    }
}