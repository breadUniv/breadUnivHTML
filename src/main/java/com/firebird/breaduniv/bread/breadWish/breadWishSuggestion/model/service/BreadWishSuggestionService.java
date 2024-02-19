package com.firebird.breaduniv.bread.breadWish.breadWishSuggestion.model.service;

import com.firebird.breaduniv.bread.breadWish.breadWishSuggestion.model.dao.BreadWishSuggestionDao;
import com.firebird.breaduniv.bread.breadWish.breadWishSuggestion.model.dto.BreadWishBoard1DTO;
import org.springframework.stereotype.Service;

@Service
public class BreadWishSuggestionService {

    private final BreadWishSuggestionDao breadWishSuggestionDao;

    public BreadWishSuggestionService(BreadWishSuggestionDao breadWishSuggestionDao){
        this.breadWishSuggestionDao = breadWishSuggestionDao;
    }

    /***
     *
     * @param boardCode
     * @return
     */

    public BreadWishBoard1DTO selectBreadBoardInfo(int boardCode) {

        BreadWishBoard1DTO breadWishBoard1DTO = breadWishSuggestionDao.selectBreadBoardInfo(boardCode);
        System.out.println("breadWishBoardDTO = " + breadWishBoard1DTO);
        return breadWishBoard1DTO;
    }
}
