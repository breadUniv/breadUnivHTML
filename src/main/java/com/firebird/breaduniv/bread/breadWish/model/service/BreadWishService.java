package com.firebird.breaduniv.bread.breadWish.model.service;


import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishCommentsDTO;
import com.firebird.breaduniv.bread.common.paging.SelectCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public interface BreadWishService {
    BreadWishBoardDTO selectQNABoard(int boardCode);
    BreadWishBoardDTO selectSuggestionBoard(int boardCode);
    BreadWishBoardDTO selectQNAView(int boardCode);
    BreadWishBoardDTO breadWishQNAPage(int boardCode);
    BreadWishCommentsDTO selectComments(int commentsCode);
    List<BreadWishBoardDTO> searchBoardByTitle(String title);
    public List<BreadWishBoardDTO> selectBoardList(SelectCriteria selectCriteria);
    int selectTotalCount(Map<String, String> searchMap);
    BreadWishBoardDTO selectBoardDetail(int boardCode);
}