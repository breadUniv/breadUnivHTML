package com.firebird.breaduniv.bread.breadGradeManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class breadGradeManagementController {

    @RequestMapping("/breadGradeManagement")
    public String breadCourseRegistration() {
            return "/bread/breadGradeManagement/breadGradeManagement";
        }
}
