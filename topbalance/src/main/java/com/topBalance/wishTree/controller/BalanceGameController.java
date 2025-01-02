package com.topBalance.wishTree.controller;

import com.topBalance.wishTree.dto.BalanceQ;
import com.topBalance.wishTree.dto.CardType;
import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.dto.WishTree;
import com.topBalance.wishTree.service.BalanceQuestionService;
import com.topBalance.wishTree.service.GameResultService;
import com.topBalance.wishTree.service.WishTreeService;
import com.topBalance.wishTree.vo.GameScores;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class BalanceGameController {

    private GameScores gamescores;

    @Autowired
    private BalanceQuestionService balanceQuestionService;

    @Autowired
    private GameResultService gameResultService;

    @Autowired
    private WishTreeService wishTreeService;

    /**
     * balancegame 시작시 필요한 초기 설정 진행
     * 1. GameScores 초기화
     * 2. BalanceQ를 DB에서 불러와 model에 데이터 저장 및 /balancegame에 랜더링.
     */
    @GetMapping("/balancegame")
    public void balanceGame(Model model, HttpSession session) {
        gamescores = new GameScores();
        Map<Integer, List<BalanceQ>> groupedQuestions = balanceQuestionService.getGroupedQuestions();
        model.addAttribute("groupedQuestions", groupedQuestions);
        Object loggedInUser = addLoggedInUser(session);
        if (loggedInUser != null) {
            model.addAttribute("loggedInUser", loggedInUser);
        }
    }

    /**
     * balancegame.html에서 유저가 선택한 answer를 통해 실질적인 GameScore를 변동하는 곳
     * 1. 총점
     * 2. 각 카드 점수별 이미지 주소
     * 3. 각 카드별 점수
     * 4. 각 카드별 해당 DB값
     * 5. MAX CardType, MIN CardType 에 따른 점심 메뉴 추천
     * 을 model 에 넣고
     * @return gameresult 로 랜더링한다.
     */
    //@PostMapping("/gameresult")
    @RequestMapping(value="/gameresult", method = {RequestMethod.GET, RequestMethod.POST})
    public String gameResult(@RequestParam Map<String, String> userAnswers,
                             Model model,
                             HttpSession session) {
        // session에서 로그인 정보 가져오기. header에 유저 정보를 담기 위해
        Object loggedInUser = addLoggedInUser(session);
        if (loggedInUser != null) {
            model.addAttribute("loggedInUser", loggedInUser);
        }

        Logger log = LoggerFactory.getLogger(BalanceGameController.class);
        log.info(userAnswers.toString());
        if (userAnswers.isEmpty()) {


            return "error/balance-game-error";
        }

        // 선택한 목록에 따른 s, c, h, d 점수 변동
        balanceQuestionService.calculatingScores(userAnswers, gamescores);

        // total 점수 구현 및 model 에 데이터 입력
        int totalScore = gameResultService.totalScore(gamescores);
        model.addAttribute("totalScore", totalScore);
        // user가 로그인 되어있을 시 totalScore update하기
        if (loggedInUser != null) {
            gameResultService.updatingTotalScore((User)loggedInUser, totalScore);
        }

        // 게임 결과 점수 각 category에 입력하고 model에 입력
        Map<String, Object> categoryScore = gameResultService.getOldCardScores(gamescores);
        model.addAttribute("categoryScore", categoryScore);

        // 카드 max, min 찾아서 점심 값 넣기
        CardType MAX = gameResultService.getMaxCategory(gamescores);
        CardType MIN = gameResultService.getMinCategory(gamescores);
        String todaysLunch = gameResultService.todaysLunch(MAX, MIN);
        model.addAttribute("todaysLunch", todaysLunch);
        // MAX 와 MIN에 따른 점심메뉴 이미지 경로 찾기 및 model에 넣기
        String lunchPath = gameResultService.getTodaysLunchPath(MAX, MIN);
        model.addAttribute("lunchPath", lunchPath);

        // 각 카드 값 변동
        gameResultService.changingCardNumber(gamescores);

        // 트럼프 이미지 경로 model에 넣기
        Map<String, Object> cardPath = gameResultService.balanceTrump(gamescores);
        model.addAttribute("cardPath", cardPath);

        // 각 카테고리 점수별 운세 결과 DB적용 및 model에 입력
        Map<String, Object> categoryResult = gameResultService.getCategoryResult(gamescores);
        model.addAttribute("categoryResult", categoryResult);

        return "gameresult";
    }

    @PostMapping("/insertWish")
    public String insertWish(@RequestParam("userWish") String userWish,
                             Model model,
                             HttpSession session) {
        Object loggedInUser = session.getAttribute("loggedInUser");
        Logger log = LoggerFactory.getLogger(this.getClass());
        if(loggedInUser != null) {
            log.info(loggedInUser.toString());
            User user = wishTreeService.getWishTree((User)loggedInUser);
            WishTree wishTree = new WishTree();// 추후 로그인 연동하면 로그인했을 때 세션으로 가져온 유저아이디로 변경할 것
            wishTree.setUserId(user.getUserId());
            wishTree.setUserWish(userWish);
            wishTreeService.insertWish(wishTree);
            return "redirect:/"; // 로그인이 안된 상태에서 댓글을 입력할 경우 로그인 페이지로 돌려보내기
        }

        return "redirect:/";
    }

    @ModelAttribute("loggedInUser")
    public Object addLoggedInUser(HttpSession session) {
        return session.getAttribute("loggedInUser");
    }

}
