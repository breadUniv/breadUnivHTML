package com.firebird.breaduniv.breadProfessor.breadMypagePro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadMypageProController {

    @RequestMapping("breadEditPro")
    public String breadEditPro(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/breadProfessor/breadMypagePro/breadEditPro";
    }

    @RequestMapping("/breadTimeTablePro")
    public String breadTimeTablePro(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/breadProfessor/breadMypagePro/breadTimeTablePro";
    }
}
