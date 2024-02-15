package com.firebird.breaduniv.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/enrollment")
    public String enrollment() {
        return "/login/enrollment";
    }

    @RequestMapping("/find_password")
    public String find_password() {
        return "/login/find_password";
    }

    @RequestMapping("/login_failed")
    public String login_failed() {
        return "/login/login_failed";
    }

    @RequestMapping("/login_input")
    public String login_input() {
        return "/login/login_input";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login/login";
    }

}
