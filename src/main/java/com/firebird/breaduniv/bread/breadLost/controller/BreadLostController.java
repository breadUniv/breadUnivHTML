package com.firebird.breaduniv.bread.breadLost.controller;

import com.firebird.breaduniv.bread.breadLost.model.dto.BreadLostDTO;
import com.firebird.breaduniv.bread.breadLost.model.service.BreadLostService;
import com.firebird.breaduniv.bread.breadNotice.model.service.BreadNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadLostController {

    private final BreadLostService breadLostService;

    @Autowired
    public BreadLostController(BreadLostService breadLostService) {
        this.breadLostService = breadLostService;
    }

    /***
     *
     * @param model
     * @return
     */
    @RequestMapping("/breadLost")
    public String breadLost(Model model) {

        int boardCode = 1;

        BreadLostDTO breadLostDTO = breadLostService.selectBreadLostInfo(boardCode);
        System.out.println("breadLostDTO ========> " + breadLostDTO);
        model.addAttribute("breadLost", breadLostDTO);


        return "/bread/breadLost/breadLost";
    }

//    @PostMapping("/breadLost")
//    public String breadPostLost() {
//        return "/bread/breadLost/breadLost";
//    }

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
