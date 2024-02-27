package com.firebird.breaduniv.bread.breadWish.breadWishSuggestion.model.dao;

import com.firebird.breaduniv.bread.breadWish.breadWishSuggestion.model.dto.BreadWishBoard1DTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadWishSuggestionDao {

    BreadWishBoard1DTO selectBreadBoardInfo(int boardCode);

}
