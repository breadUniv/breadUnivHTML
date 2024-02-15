package com.firebird.breaduniv.bread.breadLost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadLostController {

    @RequestMapping("/breadLost")
    public String breadLost() {
        return "/bread/breadLost/breadLost";
    }

    @RequestMapping("/breadLostAdmin")
    public String breadLostAdmin() {
        return "/bread/breadLost/breadLostAdmin";
    }

    @RequestMapping("/breadLostModify")
    public String breadLostModify() {
        return "/bread/breadLost/breadLostModify";
    }

    @RequestMapping("/breadLostPage")
    public String breadLostPage() {
        return "/bread/breadLost/breadLostPage";
    }

    @RequestMapping("/breadLostPageAdmin")
    public String breadLostPageAdmin() {
        return "/bread/breadLost/breadLostPageAdmin";
    }
}
