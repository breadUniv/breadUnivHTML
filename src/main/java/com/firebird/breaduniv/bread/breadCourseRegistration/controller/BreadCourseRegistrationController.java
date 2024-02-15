package com.firebird.breaduniv.bread.breadCourseRegistration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadCourseRegistrationController {

    @RequestMapping("/breadCourseRegistration")
    public String breadCourseRegistration() {
        return "/bread/breadCourseRegistration/breadCourseRegistration";
    }
}
