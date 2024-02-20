package com.firebird.breaduniv.breadProfessor.breadMypagePro.controller;

import com.firebird.breaduniv.breadProfessor.breadMypagePro.model.dto.BreadMypageProDTO;
import com.firebird.breaduniv.breadProfessor.breadMypagePro.model.service.BreadMypageProService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadMypageProController {

    private final BreadMypageProService breadMypageProService;

    public BreadMypageProController(BreadMypageProService breadMypageProService) {
        this.breadMypageProService = breadMypageProService;
    }

    @GetMapping("breadEditPro")
    public String breadEditPro(Model model) {

        int userCode = 1;

        BreadMypageProDTO breadMypageProDTO = breadMypageProService.selectBreadMypageProInfo(userCode);

        System.out.println("breadMypageProDTO =====> " + breadMypageProDTO);
        model.addAttribute("breadMypageProDTO", breadMypageProDTO);

        model.addAttribute("textColor", "#456E2A");

        return "/breadProfessor/breadMypagePro/breadEditPro";
    }

    @GetMapping("breadEditProUpdate")
    public String breadEditProUpdate(Model model) {

        int userCode = 1;
        BreadMypageProDTO breadMypageProDTO = breadMypageProService.selectBreadMypageProInfo(userCode);
        model.addAttribute("breadMypageProDTO", breadMypageProDTO);

        model.addAttribute("textColor", "#456E2A");

        return "/breadProfessor/breadMypagePro/breadEditProUpdate";
    }

    @RequestMapping("/breadTimeTablePro")
    public String breadTimeTablePro(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/breadProfessor/breadMypagePro/breadTimeTablePro";
    }
}
