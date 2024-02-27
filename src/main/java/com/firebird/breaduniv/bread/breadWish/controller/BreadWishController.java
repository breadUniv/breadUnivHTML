package com.firebird.breaduniv.bread.breadWish.controller;

import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishCommentsDTO;
import com.firebird.breaduniv.bread.breadWish.model.service.BreadWishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
//@RequestMapping("/boardWish")
public class BreadWishController {

    private final BreadWishService breadWishService;

    public BreadWishController(BreadWishService breadWishService) {
        this.breadWishService = breadWishService;
    }


    /* =========================================== QNA ==========================================*/

    /***
     * breadWish
     * @param model 데이터
     * @return
     */
    @GetMapping("/breadWishQNA")
    public String breadWishQNA(@RequestParam(required = false) String searchValue, Model model) {
        // 검색어가 있는 경우, 해당 검색어로 게시글을 검색하고 결과를 모델에 담아 뷰로 전달
        if (searchValue != null && !searchValue.isEmpty()) {
            List<BreadWishBoardDTO> searchedBoardList = breadWishService.searchBoardByTitle(searchValue);
            model.addAttribute("boardList", searchedBoardList);
        } else {
            // 검색어가 없는 경우, 모든 게시글을 조회하여 결과를 모델에 담아 뷰로 전달
            List<BreadWishBoardDTO> allBoardList = breadWishService.getAllBoardList();
            model.addAttribute("boardList", allBoardList);
        }
        return "/bread/breadWish/breadWishQNA/breadWishQNA";
    }
//    public String breadWishQNA(Model model) {
//
//
//        int boardCode = 2;
//
//        BreadWishBoardDTO breadWishBoardDTO = breadWishService.selectQNABoard(boardCode);
//        System.out.println("breadWishBoardDTO ================ " + breadWishBoardDTO);
//        model.addAttribute("breadWishBoard", breadWishBoardDTO);
//
//
//        model.addAttribute("textColor", "#456E2A");
//        return "/bread/breadWish/breadWishQNA/breadWishQNA";



    @RequestMapping("/breadWishQNAAdmin")
    public String breadWishQNAAdmin(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadWish/breadWishQNA/breadWishQNAAdmin";
    }

    @RequestMapping("/breadWishQNAModify")
    public String breadWishQNAModify() {
        return "/bread/breadWish/breadWishQNA/breadWishQNAModify";
    }

    @GetMapping("/breadWishQNAPage")
    public String breadWishQNAPage(@RequestParam int boardCode, Model model) {
        System.out.println("boardCode ========= " + boardCode);
        // boardCode 라는 요청 파라미터와 Model 객체를 매개 벼수로 받음
        BreadWishBoardDTO breadWishBoardDTO = breadWishService.breadWishQNAPage(boardCode);
        System.out.println("breadWishBoardDTO ========== " + breadWishBoardDTO);
        // 주입 받은 breadWishService를 사용하여 boardCode에 해당하는 BreadWishBoardDTO를 조회
        model.addAttribute("breadWishBoard", breadWishBoardDTO);
        // 조회한 BreadWishBoardDTO를 "breadWishBoard"라는 이름으로 Model에 추가
        // breadWishBoard 라는 이름은 html th:text="${breadWishBoard.boardViewCount}" <<  이렇게 쓰임!
        return "/bread/breadWish/breadWishQNA/breadWishQNAPage";
        // 뷰의 경로를 반환 즉 요청이 들어오면 게시글 정보 조회 후 뷰 html (뷰)로 전달함
    }

    @RequestMapping("/breadWishQNAPageAdmin")
    public String breadWishQNAPageAdmin() {
        return "/bread/breadWish/breadWishQNA/breadWishQNAPageAdmin";
    }

    /* ========================= Suggestion (불편/건의사항) ======================== */

    @RequestMapping("/breadWishSuggestion")
    public String breadWishSuggestion(Model model) {

        int boardCode = 3;

        BreadWishBoardDTO breadWishBoardDTO = breadWishService.selectSuggestionBoard(boardCode);
        System.out.println("breadWishBoardDTO -------- " + breadWishBoardDTO);
        model.addAttribute("breadWishBoard", breadWishBoardDTO);


        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestion";
    }


    @RequestMapping("/breadWishSuggestionAdmin")
    public String breadWishSuggestionAdmin(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestionAdmin";
    }

    @RequestMapping("/breadWishSuggestionModify")
    public String breadWishSuggestionModify() {
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestionModify";
    }

    @RequestMapping("/breadWishSuggestionPage")
    public String breadWishSuggestionPage(Model model) {
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestionPage";
    }

    @RequestMapping("/breadWishSuggestionPageAdmin")
    public String breadWishSuggestionPageAdmin() {
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestionPageAdmin";
    }
}


//    @GetMapping("/breadWishQNAPage")
//    public String selectQNAView(@RequestParam int boardcode, Model model) {
//
//        log.info("");
//        log.info("");
//        log.info("[BoardWishController] ========================================================= start");
//
//        BreadWishBoardDTO  viewCount = breadWishService.selectQNAView(boardcode);
//        log.info("[BoardWishController] viewCount : " + viewCount);
//
//        model.addAttribute("viewCount", viewCount);
//
//        log.info("[BoardWishController ========================================================= end");
//        return "/bread/breadWish/breadWishQNA/breadWishQNA";
//    }
//}

