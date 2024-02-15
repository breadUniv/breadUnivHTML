package com.firebird.breaduniv.breadProfessor.breadGradeMangementPro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadGradeManagementPro {

    @RequestMapping("/breadGradeListPro")
    public String breadGradeListPro() {
        return "/breadProfessor/breadGradeManagementPro/breadGradeListPro";
    }

    @RequestMapping("/breadGradeManagementPro")
    public String breadGradeManagementPro() {
        return "/breadProfessor/breadGradeManagementPro/breadGradeManagementPro";
    }
}
