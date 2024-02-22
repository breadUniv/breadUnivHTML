package com.firebird.breaduniv.bread.breadWish.model.service;

import com.firebird.breaduniv.bread.breadWish.model.dao.BreadWishMapper;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import org.springframework.stereotype.Service;


@Service
public class BreadWishService {

    private final BreadWishMapper breadWishMapper;

    public BreadWishService(BreadWishMapper breadWishMapper) {
        this.breadWishMapper = breadWishMapper;
    }


    public BreadWishBoardDTO selectQNABoard(int boardCode) {


        BreadWishBoardDTO breadWishBoardDTO = breadWishMapper.selectQNABoard(boardCode);
        System.out.println("breadWishBoardDTO = " + breadWishBoardDTO);
        return breadWishBoardDTO;

    }
    public BreadWishBoardDTO selectSuggestionBoard ( int boardCode){
        BreadWishBoardDTO breadWishBoardDTO = breadWishMapper.selectSuggestionBoard(boardCode);
        System.out.println("breadWishBoardDTO = " + breadWishBoardDTO);
        return breadWishBoardDTO;


    }
}

//    public List<BreadWishBoardDTO> selectBreadBoardInfo(){
//        return breadWishMapper.getMapper(BreadWishMapper.class).selectBreadBoardInfo();
//    }
