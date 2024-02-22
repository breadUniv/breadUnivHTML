package com.firebird.breaduniv.bread.breadWish.model.dao;

import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadWishMapper {
    BreadWishBoardDTO selectQNABoard(int boardCode);

    BreadWishBoardDTO selectSuggestionBoard(int boardCode);

//    List<BreadWishBoardDTO> selectBreadBoardInfo();
//}
}