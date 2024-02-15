package com.firebird.breaduniv.bread.breadAcademicAdministration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class breadAcademicAdministrationController {

    @RequestMapping("/breadAcademicAdministration")
    public String breadAcademicAdministration() { return "/bread/breadAcademicAdministration/breadAcademicAdministration";}
}
