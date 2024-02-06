package com.firebird.breaduniv.bread.breadWish.breadWishQNA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadWishQNAController {

    @RequestMapping("/breadWishQNA")
    public String breadWishQNA() {
        return "/bread/breadWish/breadWishQNA/breadWishQNA";
    }


}
