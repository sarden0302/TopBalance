package com.topBalance.wishTree.controller;


import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // 테스트용 아이디들 보기
   /* @GetMapping("/")
    public String index(Model model) {
        List<Map<String, Object>> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }*/

    /**
     * 회원가입 페이지
     *
     * @return
     */
    @GetMapping("/register")
    public String register() {

        return "register";
    }

    /**
     * 회원가입 아이디 중복 확인
     * @param userId 유저 닉네임
     * @param response ajax 반환값
     * @throws IOException getWriter().write 예외처리용
     */
    @PostMapping("/check-userId")
    public void checkUsers(@RequestParam("userId") String userId,
                            HttpServletResponse response
                            )throws IOException {
        boolean userExists = userService.checkUsers(userId);
        response.setContentType("application/json");
        response.getWriter().write("{\"userExists\" : " + userExists + "}");
    }

    /**
     * 회원가입 성공 페이지
     * @param user 유저가 작성한 모든 유저정보
     * @param model 작업 성공시 성공 메세지 전달
     * @return
     */
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
     * @param userId 유저 닉네임
     * @param userPassword 유저 비밀번호
     * @param model 실패 메세지
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

    /**
     * 세션생성
     * @param session 로그인 유지 세션
     * @return
     */
    @ModelAttribute("loggedInUser")
    public Object addLoggedInUser(HttpSession session) {
        return session.getAttribute("loggedInUser");
    }

    /**
     * 로그아웃
     * @param session 로그아웃시 발급 세션 만료
     * @return
     */
    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    /**
     * 유저가 회원가입 정보보기
     * @param model
     * @param session 로그인된 유저 세션 정보
     * @return
     */
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

    /**
     * 회원정보 수정
     * @param model 로그인된 회원정보 수정
     * @param session 로그인시 저장된 유저 정보
     * @return
     */
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

    /**
     * 회원정보 수정 성공
     * @param user 새로 작성된 유저 정보
     * @param model 수정 성공 메세지
     * @param session 로그인된 유저 정보
     * @return
     */
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

    /**
     * 비밀번호찾기(아이디,핸드폰번호)
     * @return
     */
    @GetMapping("/find-password")
    public String findByPassword() {
        return "find-password";
    }

    /**
     * 비밀번호찾기 결과
     * @param userId 유저 닉네임
     * @param userPhone 유저 핸드폰 번호 - 포함
     * @param model 찾은 유저 비밀번호 전달
     * @return
     */
    @GetMapping("/find-password-result")
    public String findByPassword(@RequestParam("userId") String userId,
                                 @RequestParam("userPhone") String userPhone,
                                 Model model) {
        String userPassword = userService.findByPassword(userId, userPhone);
        model.addAttribute("userPassword", userPassword);
        return "find-password-result";
    }

    /**
     * 아이디 찾기 (이름, 핸드폰번호, 생년월일)
     * @return
     */
    @GetMapping("/find-id")
    public String findById() {
        return "find-id";
    }

    /**
     * 어아다첮가 결과
     * @param userName 유저 성함
     * @param userPhone 핸드폰번호
     * @param userBirthdate 생년월일
     * @param model 찾은 유저 아이디 반환
     * @return
     */
    @GetMapping("/find-id-result")
    public String findById(@RequestParam("userName") String userName,
                           @RequestParam("userPhone") String userPhone,
                           @DateTimeFormat(pattern = "yyyy-MM-dd") Date userBirthdate,
                           Model model) {
        String findID = userService.findById(userName, userPhone, userBirthdate);
        model.addAttribute("userId", findID);
        return "find-id-result";
    }

}

