package com.firebird.breaduniv.bread.breadLectureInquiry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadLectureInquiryController {

    @RequestMapping("/breadLectureInquiry")
    public String breadLectureInquiry(){
        return "/bread/breadLectureInquiry/breadLectureInquiry";
    }

    @RequestMapping("/breadLectureInquiryAdmin")
    public String breadLectureInquiryAdmin(){
        return "/bread/breadLectureInquiry/breadLectureInquiryAdmin";
    }

    @RequestMapping("/breadLectureIsertAdmin")
    public String breadLectureIsertAdmin(){
        return "/bread/breadLectureInquiry/breadLectureIsertAdmin";
    }

}
