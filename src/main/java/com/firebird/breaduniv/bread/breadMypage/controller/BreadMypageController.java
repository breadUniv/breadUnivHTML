package com.firebird.breaduniv.bread.breadMypage.controller;

import com.firebird.breaduniv.bread.breadCourseRegistration.controller.BreadCourseRegistrationController;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadCourseRegistrationDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadEnrollmentDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import com.firebird.breaduniv.bread.breadMypage.model.service.BreadMypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/breadEdit")
    public String breadEdit(Model model) {

        // 임시로 사용자 아이디를 고정해서 테스트
        int userCode = 3;

        // service -> dao -> DB 후에 역순으로 다시 값을 들고 돌아온다.
        BreadUserDTO breadUserDTO = breadMypageService.selectBreadUserInfo(userCode);

        System.out.println("breadUserDTO ============> " + breadUserDTO);
        model.addAttribute("breadUser", breadUserDTO);

        model.addAttribute("textColor", "#456E2A");

        return "/bread/breadMypage/breadEdit";
    }

    @GetMapping("/breadEditUpdate")
    public String breadEditUpdate(Model model) {
        int userCode = 3;
        BreadUserDTO breadUserDTO = breadMypageService.selectBreadUserInfo(userCode);
        model.addAttribute("breadUser", breadUserDTO);
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadEditUpdate";
    }

    @PostMapping("/breadEditUpdate")
    public String breadEditUpdate(Model model, @ModelAttribute BreadUserDTO breadUser, @RequestParam String firstAddress, @RequestParam String secondAddress) {

        System.out.println("firstAddress = " + firstAddress);
        System.out.println("secondAddress = " + secondAddress);

        String sumAddress = firstAddress + "$" + secondAddress;
        System.out.println("sumAddress = " + sumAddress);
        breadUser.setUserAddress(sumAddress);
        System.out.println("breadUser = " + breadUser);
        int userCode = 3;
        // service로 처리를 진행

        model.addAttribute("textColor", "#456E2A");
        return "/breadEdit";
    }

    @RequestMapping("/breadEnrollment")
    public String breadEnrollment(Model model) {
        int courseCode = 1;
        BreadEnrollmentDTO breadEnrollmentDTO = breadMypageService.selectBreadCourseInfo(courseCode);
        model.addAttribute("breadEnrollment", breadEnrollmentDTO);
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadEnrollment";
    }

    @RequestMapping("/breadTimeTable")
    public String breadTimeTable(Model model) {
        int courseRegistrationCode = 1;
        BreadCourseRegistrationDTO breadCourseRegistrationDTO = breadMypageService.selectBreadCourseRegistrationInfo(courseRegistrationCode);
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadMypage/breadTimeTable";
    }
}
