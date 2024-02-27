package com.firebird.breaduniv.bread.breadWish.model.dao;

import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishCommentsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BreadWishMapper {

    BreadWishBoardDTO selectQNABoard(int boardCode);

    BreadWishBoardDTO selectSuggestionBoard(int boardCode);

    BreadWishBoardDTO selectQNAView(int boardCode);
    //selectQNAView 메서드는 조회만을 목적으로 하고, 결과를 반환할 필요가 없으면 BreadWishBoardDTO -> void로 변경해서 씀

    BreadWishCommentsDTO selectComments(int commentsCode);

    int viewCount(int boardCode);

    BreadWishBoardDTO breadWishQNAPage(int boardCode);
    List<BreadWishBoardDTO> searchBoardByTitle(String searchValue);
    List<BreadWishBoardDTO> getAllBoardList();
}


