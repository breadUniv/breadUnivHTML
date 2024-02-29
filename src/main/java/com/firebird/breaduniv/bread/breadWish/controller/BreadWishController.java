package com.firebird.breaduniv.bread.breadWish.controller;

import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishCommentsDTO;
import com.firebird.breaduniv.bread.breadWish.model.service.BreadWishService;
import com.firebird.breaduniv.bread.common.paging.Pagenation;
import com.firebird.breaduniv.bread.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
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
//@RequestMapping("/breadWish")
public class BreadWishController {

    private final BreadWishService breadWishService;

    public BreadWishController(BreadWishService breadWishService) {
        this.breadWishService = breadWishService;
    }

    /* =========================================== QNA ==========================================*/

    /***
     * breadWish
     * @param searchCondition
     * @param searchValue
     * @param pageNo
     * @param mv
     * @return
     */
    @GetMapping(value="/breadWishQNA")
    public ModelAndView breadWishQNA(@RequestParam(required = false) String searchCondition,
                                     @RequestParam(required = false) String searchValue,
                                     @RequestParam(value="currentPage", defaultValue = "1") int pageNo,
                                     @RequestParam(required = false) String type,
                                     ModelAndView mv) {

        // 아래는 예외처리 발생 시 문구
        try {
            // 해당 메서드의 내용을 여기에 작성
            // 예외가 발생할 수 있는 코드
        } catch (Exception e) {
            // 예외 처리
            log.error("예외 발생: ", e);
            // 예외가 발생했을 때 사용자에게 메시지 표시 등의 처리 가능
            mv.addObject("errorMessage", "오류가 발생했습니다. 지원팀에 문의하세요.");
            mv.setViewName("errorPage"); // 오류 페이지로 이동
            return mv;
        }

        // 예외가 발생하지 않은 경우 원래의 처리를 계속 진행
        // 여기서 type 파라미터 값을 사용하여 로직을 처리할 수 있습니다.
        if (type != null && type.equals("11")) {
            System.out.println("type ============== " + type);
        }

        log.info("[BoardControllerTest!!!!!!!!!!!!!!!!] ========================================================= start");


        // serchMap에 '검색조건'과 '검색값' 넣기
        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("boardCategoryCode", type);
        log.info("[BoardWishController!!!!!] 컨트롤러에서 검색조건 확인하기 : " + searchMap);

        // 전체 게시물 수 조회, 검색조건이 있는 경우 조건에 맞게 게시물 수 조회
        int totalCount = breadWishService.selectTotalCount(searchMap);
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
        log.info("[BoardWishController] selectCriteria : " + selectCriteria);

        // 'boardCategoryCode'가 13인 게시물만 조회하도록 검색 조건 추가
//        searchMap.put("boardCategoryCode", "13");

        /* 조회해 온다 */
        List<BreadWishBoardDTO> boardList = breadWishService.selectBoardList(selectCriteria);
        log.info("[BoardController] boardList : " + boardList);

        mv.addObject("boardList", boardList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[BoardController] SelectCriteria : " + selectCriteria);
        mv.setViewName("/bread/breadWish/breadWishQNA/breadWishQNA");

        log.info("[BoardWishController] ========================================================= end !!!! ");


        return mv;

    }
//    @GetMapping("/breadWishQNA")
//    public String breadWishQNA(@RequestParam(required = false) String searchValue, Model model) {
//        // 검색어가 있는 경우, 해당 검색어로 게시글을 검색하고 결과를 모델에 담아 뷰로 전달
//        if (searchValue != null && !searchValue.isEmpty()) {
//            List<BreadWishBoardDTO> searchedBoardList = breadWishService.searchBoardByTitle(searchValue);
//            model.addAttribute("boardList", searchedBoardList);
//        } else {
//            // 검색어가 없는 경우, 모든 게시글을 조회하여 결과를 모델에 담아 뷰로 전달
//            List<BreadWishBoardDTO> allBoardList = breadWishService.getAllBoardList();
//            model.addAttribute("boardList", allBoardList);
//        }
//        return "/bread/breadWish/breadWishQNA/breadWishQNA";
//    }

//    @GetMapping("/breadWishQNA")
//    public String breadWishQNA(Model model) {
//
//
//        int boardCode = 2;
//
//        BreadWishBoardDTO breadWishBoardDTO = breadWishService.selectQNABoard(boardCode);
//        System.out.println("breadWishBoardDTO ================ " + breadWishBoardDTO);
//        model.addAttribute("breadWishBoard", breadWishBoardDTO);
//
//
//        model.addAttribute("textColor", "#456E2A");
//        return "/bread/breadWish/breadWishQNA/breadWishQNA";}
//


    @RequestMapping("/breadWishQNAAdmin")
    public String breadWishQNAAdmin(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadWish/breadWishQNA/breadWishQNAAdmin";
    }

    @RequestMapping("/breadWishQNAModify")
    public String breadWishQNAModify() {
        return "/bread/breadWish/breadWishQNA/breadWishQNAModify";
    }

//    @GetMapping("/breadWishQNAPage")
//    public String breadWishQNAPage(@RequestParam int boardCode, Model model) {
//        System.out.println("boardCode ========= " + boardCode);
//        // boardCode 라는 요청 파라미터와 Model 객체를 매개 벼수로 받음
//        BreadWishBoardDTO breadWishBoardDTO = breadWishService.breadWishQNAPage(boardCode);
//        System.out.println("breadWishBoardDTO ========== " + breadWishBoardDTO);
//        // 주입 받은 breadWishService를 사용하여 boardCode에 해당하는 BreadWishBoardDTO를 조회
//        model.addAttribute("breadWishBoard", breadWishBoardDTO);
//        // 조회한 BreadWishBoardDTO를 "breadWishBoard"라는 이름으로 Model에 추가
//        // breadWishBoard 라는 이름은 html th:text="${breadWishBoard.boardViewCount}" <<  이렇게 쓰임!
//        return "/bread/breadWish/breadWishQNA/breadWishQNAPage";
//        // 뷰의 경로를 반환 즉 요청이 들어오면 게시글 정보 조회 후 뷰 html (뷰)로 전달함
//    }
    @GetMapping("/breadWishQNAPage")
    public String breadWishQNAPage(@RequestParam int no, Model model){
        System.out.println("no = " + no);

        BreadWishBoardDTO breadWishBoardDTO = breadWishService.selectBoardDetail(no);
        System.out.println("breadWishBoardDTO =============== " + breadWishBoardDTO);

        model.addAttribute("breadWishBoard", breadWishBoardDTO);
        return "/bread/breadWish/breadWishQNA/breadWishQNAPage";
    }

    @RequestMapping("/breadWishQNAPageAdmin")
    public String breadWishQNAPageAdmin() {
        return "/bread/breadWish/breadWishQNA/breadWishQNAPageAdmin";
    }

    /* ========================= Suggestion (불편/건의사항) ======================== */

    @RequestMapping("/breadWishSuggestion")
    public String breadWishSuggestion(Model model) {

        int boardCode = 3;

        BreadWishBoardDTO breadWishBoardDTO = breadWishService.selectSuggestionBoard(boardCode);
        System.out.println("breadWishBoardDTO -------- " + breadWishBoardDTO);
        model.addAttribute("breadWishBoard", breadWishBoardDTO);


        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestion";
    }


    @RequestMapping("/breadWishSuggestionAdmin")
    public String breadWishSuggestionAdmin(Model model) {
        model.addAttribute("textColor", "#456E2A");
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestionAdmin";
    }

    @RequestMapping("/breadWishSuggestionModify")
    public String breadWishSuggestionModify() {
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestionModify";
    }

    @RequestMapping("/breadWishSuggestionPage")
    public String breadWishSuggestionPage(Model model) {
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestionPage";
    }

    @RequestMapping("/breadWishSuggestionPageAdmin")
    public String breadWishSuggestionPageAdmin() {
        return "/bread/breadWish/breadWishSuggestion/breadWishSuggestionPageAdmin";
    }
}


//    @GetMapping("/breadWishQNAPage")
//    public String selectQNAView(@RequestParam int boardcode, Model model) {
//
//        log.info("");
//        log.info("");
//        log.info("[BoardWishController] ========================================================= start");
//
//        BreadWishBoardDTO  viewCount = breadWishService.selectQNAView(boardcode);
//        log.info("[BoardWishController] viewCount : " + viewCount);
//
//        model.addAttribute("viewCount", viewCount);
//
//        log.info("[BoardWishController ========================================================= end");
//        return "/bread/breadWish/breadWishQNA/breadWishQNA";
//    }
//}

