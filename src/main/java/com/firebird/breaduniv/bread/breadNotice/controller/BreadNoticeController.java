package com.firebird.breaduniv.bread.breadNotice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadNoticeController {

    @RequestMapping("/breadNotice")
    public String breadNotice() {
        return "/bread/breadNotice/breadNotice";
    }

    @RequestMapping("/breadNoticeAdmin")
    public String breadNoticeAdmin() {
        return "/bread/breadNotice/breadNoticeAdmin";
    }

    @RequestMapping("/breadNoticeModifyAdmin")
    public String breadNoticeModifyAdmin() {
        return "/bread/breadNotice/breadNoticeModifyAdmin";
    }

    @RequestMapping("/breadNoticePage")
    public String breadNoticePage() {
        return "/bread/breadNotice/breadNoticePage";
    }

    @RequestMapping("/breadNoticePageAdmin")
    public String breadNoticePageAdmin() {
        return "/bread/breadNotice/breadNotice";
    }
}