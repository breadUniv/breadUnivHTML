package com.firebird.breaduniv.bread.breadMypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadMypageController {

    @RequestMapping("/breadEdit")
    public String breadEdit() {
        return "/bread/breadMypage/breadedit";
    }

    @RequestMapping("/breadEnrollment")
    public String breadEnrollment() {
        return "/bread/breadMypage/breadEnrollment";
    }

    @RequestMapping("/breadTimeTable")
    public String breadWishQNAAdmin(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadTimeTable";
    }
}
