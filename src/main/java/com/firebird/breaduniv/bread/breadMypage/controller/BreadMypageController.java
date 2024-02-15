package com.firebird.breaduniv.bread.breadMypage.controller;

import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import com.firebird.breaduniv.bread.breadMypage.model.service.BreadMypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BreadMypageController {

    private final BreadMypageService breadMypageService;

    @Autowired
    public BreadMypageController(BreadMypageService breadMypageService) {
        this.breadMypageService = breadMypageService;
    }

    /***
     * 마이페이지
     * @param model 데이터
     * @return
     */
    @RequestMapping("/breadEdit")
    public String breadEdit(Model model) {

        // 임시로 사용자 아이디를 고정해서 테스트
        int userId = 3;

        // service -> dao -> DB 후에 역순으로 다시 값을 들고 돌아온다.
        BreadUserDTO breadUserDTO = breadMypageService.selectBreadUserInfo(userId);

        System.out.println("breadUserDTO ============> " + breadUserDTO);
        model.addAttribute("breadUser", breadUserDTO);
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadedit";
    }

    @RequestMapping("/breadEnrollment")
    public String breadEnrollment(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadEnrollment";
    }

    @RequestMapping("/breadTimeTable")
    public String breadTimeTable(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadTimeTable";
    }
}
