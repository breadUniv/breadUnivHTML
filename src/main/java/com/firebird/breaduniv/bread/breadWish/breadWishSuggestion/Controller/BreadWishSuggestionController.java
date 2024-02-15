package com.firebird.breaduniv.bread.breadWish.breadWishSuggestion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadWishSuggestionController {

    @RequestMapping("/breadWishSuggestion")
    public String breadWishSuggestion(Model model) {
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
