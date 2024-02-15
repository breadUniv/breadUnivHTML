package com.firebird.breaduniv.breadProfessor.breadAttendancePro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadAttendanceProController {
    @RequestMapping("/breadAttendancePro")
    public String breadAttendancePro() {
        return "breadProfessor/breadAttendancePro/breadAttendancePro";
    }
}
