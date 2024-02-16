package com.firebird.breaduniv.bread.breadWish.breadWishQNA.controller;

import com.firebird.breaduniv.bread.breadMypage.model.service.BreadMypageService;
import com.firebird.breaduniv.bread.breadWish.breadWishQNA.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.breadWishQNA.model.service.BreadWishQNAService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadWishQNAController {

    private final BreadWishQNAService breadWishQNAService;


    public BreadWishQNAController(BreadWishQNAService breadWishQNAService) {
        this.breadWishQNAService = breadWishQNAService;
    }

    /***
     * 불편/건의사항
     * @param model 데이터
     * @return
     */
    @RequestMapping("/breadWishQNA")
    public String breadWishQNA(Model model) {


        int boardCode = 1;

        BreadWishBoardDTO breadWishBoardDTO = breadWishQNAService.selectBreadBoardInfo(boardCode);
        System.out.println("breadWishBoardDTO = " + breadWishBoardDTO);




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
    public String breadWishPage() {
        return "/bread/breadWish/breadWishQNA/breadWishQNAPage";
    }

    @RequestMapping("/breadWishQNAPageAdmin")
    public String breadWishQNAPageAdmin() {
        return "/bread/breadWish/breadWishQNA/breadWishQNAPageAdmin";
    }
}
