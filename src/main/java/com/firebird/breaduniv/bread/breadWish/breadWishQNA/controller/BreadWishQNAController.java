package com.firebird.breaduniv.bread.breadWish.breadWishQNA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadWishQNAController {

    @RequestMapping("/breadWishQNA")
    public String breadWishQNA(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadWish/breadWishQNA/breadWishQNA";
    }

    @RequestMapping("/breadWishQNAAdmin")
    public String breadWishQNAAdmin(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadWish/breadWishQNA/breadWishQNAAdmin";
    }

    @RequestMapping("/breadWsihQNAModify")
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
