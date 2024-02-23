package com.firebird.breaduniv.bread.breadNotice.controller;

import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import com.firebird.breaduniv.bread.breadNotice.model.service.BreadNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BreadNoticeController {

    private final BreadNoticeService breadNoticeService;

    @Autowired
    public BreadNoticeController(BreadNoticeService breadNoticeService) {
        this.breadNoticeService = breadNoticeService;
    }

    /**
     * 공지사항
     * @param model 게시판 정보
     * @return
     */
    @RequestMapping("/breadNotice")
    public String breadNotice(Model model) {
        int boardCode = 6;
        // DTO에서 boardCode 6에 해당하는 정보 가져오기
        BreadNoticeDTO breadNoticeDTO = breadNoticeService.selectBreadNoticeInfo(boardCode);
        System.out.println("breadNoticeDTO =========> " + breadNoticeDTO);

        // breadNotice에 위에서 가져온 breadNoticeDTO 넣어줌
        model.addAttribute("breadNotice", breadNoticeDTO);

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