package com.firebird.breaduniv.breadProfessor.breadClassManagementPro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadClassManagementProController {
    @RequestMapping("/breadClassManagementPro")
    public String breadClassManagementPro() {
        return "/breadProfessor/breadClassManagementPro/breadClassManagementPro";
    }
}
