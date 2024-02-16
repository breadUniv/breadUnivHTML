package com.firebird.breaduniv.bread.breadWish.breadWishQNA.model.dao;

import com.firebird.breaduniv.bread.breadWish.breadWishQNA.model.dto.BreadWishBoardDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadWishQNADao {

    BreadWishBoardDTO selectBreadBoardInfo(int boardCode);
}
    
