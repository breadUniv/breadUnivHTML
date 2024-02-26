package com.firebird.breaduniv.bread.breadNotice.controller;

import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import com.firebird.breaduniv.bread.breadNotice.model.service.BreadNoticeService;
import com.firebird.breaduniv.bread.breadNotice.model.service.BreadNoticeServiceImpl;
import com.firebird.breaduniv.bread.common.paging.Pagenation;
import com.firebird.breaduniv.bread.common.paging.SelectCriteria;
import com.firebird.breaduniv.breadProfessor.breadMypagePro.controller.BreadMypageProController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/Notice")
public class BreadNoticeController {

    // 사용하는 서비스의 구현체를 제공하기 위해 생성자를 통해 BreadNoticeServiceImpl 객체를 주입
    private final BreadNoticeServiceImpl breadNoticeServiceImpl;

    public BreadNoticeController(BreadNoticeServiceImpl breadNoticeServiceImpl) {
        this.breadNoticeServiceImpl = breadNoticeServiceImpl;
    }

    /**
     *
     * @param searchCondition
     * @param searchValue
     * @param pageNo
     * @param mv
     * @return
     */
    @GetMapping(value = "/breadNotice")
    public ModelAndView breadNotice(@RequestParam(required = false) String searchCondition,
                                    @RequestParam(required = false) String searchValue,
                                    @RequestParam(value="currentPage", defaultValue = "1") int pageNo,
                                    ModelAndView mv) {

        log.info("[BoardController] ========================================================= start");


        // serchMap에 '검색조건'과 '검색값' 넣기
        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        log.info("[BoardController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);

        // 전체 게시물 수 조회, 검색조건이 있는 경우 조건에 맞게 게시물 수 조회
        int totalCount = breadNoticeServiceImpl.selectTotalCount(searchMap);
        log.info("[BoardController] totalBoardCount : " + totalCount);

        /* 한 페이지에 보여 줄 게시물 수(파라미터로 전달 받아도 됨) */
        int limit = 10;

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        SelectCriteria selectCriteria = null;

        // 페이지네이션 처리를 위해 SelectCriteria 객체를 생성하는 데 사용
        if(searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }
        log.info("[BoardController] selectCriteria : " + selectCriteria);

        // 'boardCategoryCode'가 13인 게시물만 조회하도록 검색 조건 추가
        searchMap.put("boardCategoryCode", "13");

        /* 조회해 온다 */
        List<BreadNoticeDTO> boardList = breadNoticeServiceImpl.selectBoardList(selectCriteria);
        log.info("[BoardController] boardList : " + boardList);

        mv.addObject("boardList", boardList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[BoardController] SelectCriteria : " + selectCriteria);
        mv.setViewName("/bread/breadNotice/breadNotice");

        log.info("[BoardController] ========================================================= end");

        return mv;
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