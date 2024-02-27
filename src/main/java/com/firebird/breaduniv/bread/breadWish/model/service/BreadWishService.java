package com.firebird.breaduniv.bread.breadWish.model.service;


import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishCommentsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BreadWishService {
    BreadWishBoardDTO selectQNABoard(int boardCode);
    BreadWishBoardDTO selectSuggestionBoard(int boardCode);
    BreadWishBoardDTO selectQNAView(int boardCode);
    BreadWishBoardDTO breadWishQNAPage(int boardCode);
    BreadWishCommentsDTO selectComments(int commentsCode);
    List<BreadWishBoardDTO> searchBoardByTitle(String title);
    List<BreadWishBoardDTO> getAllBoardList();
}