package com.firebird.breaduniv.breadProfessor.breadMypagePro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadMypageProController {

    @RequestMapping("breadEditPro")
    public String breadEditPro() {
        return "/breadProfessor/breadMypagePro/breadEditPro";
    }

    @RequestMapping("/breadTimeTablePro")
    public String breadTimeTablePro() {
        return "/breadProfessor/breadMypagePro/breadTimeTablePro";
    }
}
