package com.firebird.breaduniv.bread.breadWish.controller;

import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.model.service.BreadWishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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
    @RequestMapping("/breadWishQNA")
    public String breadWishQNA(Model model) {


        int boardCode = 2;

        BreadWishBoardDTO breadWishBoardDTO = breadWishService.selectQNABoard(boardCode);
        System.out.println("breadWishBoardDTO ================ " + breadWishBoardDTO);
        model.addAttribute("breadWishBoard", breadWishBoardDTO);


        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadWish/breadWishQNA/breadWishQNA";
    }


    @RequestMapping("/breadWishQNAAdmin")
    public String breadWishQNAAdmin(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadWish/breadWishQNA/breadWishQNAAdmin";
    }

    @RequestMapping("/breadWishQNAModify")
    public String breadWishQNAModify() {
        return "/bread/breadWish/breadWishQNA/breadWishQNAModify";
    }

    @RequestMapping("/breadWishQNAPage")
    public String breadWishQNAPage(Model model) {
//        log.info("");
//        log.info("[BreadWishController] ============================");

       int boardCode = 2;

        BreadWishBoardDTO breadWishBoardDTO = breadWishService.selectQNAView(boardCode);
//        log.info("breadWishBoardDTO ------------------------- " + breadWishBoardDTO);

        model.addAttribute("breadWishBoard", breadWishBoardDTO);
        return "/bread/breadWish/breadWishQNA/breadWishQNAPage";
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

