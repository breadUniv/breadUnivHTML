package com.firebird.breaduniv.bread.breadWish.model.dao;

import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishCommentsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadWishMapper {
    BreadWishBoardDTO selectQNABoard(int boardCode);

    BreadWishBoardDTO selectSuggestionBoard(int boardCode);

    BreadWishBoardDTO selectQNAView(int boardCode);

    BreadWishCommentsDTO selectComments(int commentsCode);



//    int selectTotalCount(Map<String, Objects> searchMap);/* 레코드 총 개수 조회 역할*/
//
//    List<BreadWishBoardDTO> selectBoardList(Map<String, Object> selectCriteria2);
//
//    int incrementboardViewCount(int post_code);
}


