package com.firebird.breaduniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @PostMapping("/search")
    public String search(@RequestParam("query") String query) {
        return "redirect/search-result?query=" + query;
    }
}
