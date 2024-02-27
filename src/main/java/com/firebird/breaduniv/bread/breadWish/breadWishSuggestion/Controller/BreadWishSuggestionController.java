package com.firebird.breaduniv.bread.breadWish.breadWishSuggestion.Controller;

import com.firebird.breaduniv.bread.breadWish.breadWishQNA.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.breadWishSuggestion.model.dto.BreadWishBoard1DTO;
import com.firebird.breaduniv.bread.breadWish.breadWishSuggestion.model.service.BreadWishSuggestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class BreadWishSuggestionController {

    private final BreadWishSuggestionService breadWishSuggestionService;


    public BreadWishSuggestionController(BreadWishSuggestionService breadWishSuggestionService) {
        this.breadWishSuggestionService = breadWishSuggestionService;
    }

    /***
     * 불편/건의사항
     * @param model
     * @return
     */


    @RequestMapping("/breadWishSuggestion")
    public String breadWishSuggestion(Model model) {

        int boardCode = 3;

        BreadWishBoard1DTO breadWishBoard1DTO = breadWishSuggestionService.selectBreadBoardInfo(boardCode);
        System.out.println("breadWishBoardDTO ==========-- " + breadWishBoard1DTO);
        model.addAttribute("breadWishBoard", breadWishBoard1DTO);


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
    public String breadWishSuggestionPage() {
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestionPage";
    }

    @RequestMapping("/breadWishSuggestionPageAdmin")
    public String breadWishSuggestionPageAdmin() {
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestionPageAdmin";
    }
}
