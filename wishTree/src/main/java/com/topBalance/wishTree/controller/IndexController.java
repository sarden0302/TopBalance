package com.topBalance.wishTree.controller;

import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.service.RankingService;
import com.topBalance.wishTree.service.WishService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller // Spring MVC 컨트롤러로 사용되는 클래스임을 지정. 사용자 요청처리, HTML 템플릿으로 데이터 전달
public class IndexController {
    @Autowired
    private RankingService rankingService;
    @Autowired
    private WishService wishService;

    @GetMapping("/") // - 엔드포인트 html 파일에 작성한 화면을 보여줄 주소
    // HTTP GET 요청매핑. 엔드포인트에 대한 요청 처리하고 결과 반환
    public String ranksindex(Model model,  HttpSession session) { // model은 index.html에 자바로 작성한 값을 전달할 변수
        Object loggedInUser = addLoggedInUser(session); // 유저컨트롤러에서 로그인시 생성한 세션 불러오기
        if (loggedInUser != null) {
            model.addAttribute("loggedInUser", loggedInUser);
        }

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
//    @PostMapping("/selectranks-success") // HTTP POST 요청매핑.
//    public String selectSuccess(@ModelAttribute("ranks") User user, Model model) {
//
//        model.addAttribute("msg", "랭킹 조회완료");
//        return "success";
//    }
//    @PostMapping("/selectwishs-success")
//    public String registerSuccess(@ModelAttribute("wishs") User user, Model model) {
//
//        model.addAttribute("msg", "한해소망 조회완료");
//        return "success"; //회원가입이 무사히 완료될 경우 success 페이지로 이동
//    }

    @ModelAttribute("loggedInUser")
    public Object addLoggedInUser(HttpSession session) {
        return session.getAttribute("loggedInUser");
    }
}
