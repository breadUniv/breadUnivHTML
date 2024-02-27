package com.firebird.breaduniv.bread.breadWish.model.service;

import com.firebird.breaduniv.bread.breadWish.model.dao.BreadWishMapper;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishCommentsDTO;

import org.springframework.stereotype.Service;

@Service
public class BreadWishServiceImpl implements BreadWishService {

    private final BreadWishMapper breadWishMapper;

    public BreadWishServiceImpl(BreadWishMapper breadWishMapper) {
        this.breadWishMapper = breadWishMapper;
    }

    @Override
    public BreadWishBoardDTO selectQNABoard(int boardCode) {
        return breadWishMapper.selectQNABoard(boardCode);
    }

    @Override
    public BreadWishBoardDTO selectSuggestionBoard(int boardCode) {
        return breadWishMapper.selectSuggestionBoard(boardCode);
    }

    @Override
    public BreadWishBoardDTO selectQNAView(int boardCode) {
        return breadWishMapper.selectQNAView(boardCode);
    }

    @Override
    public BreadWishCommentsDTO selectComments(int commentsCode) {
        return breadWishMapper.selectComments(commentsCode);
    }
}