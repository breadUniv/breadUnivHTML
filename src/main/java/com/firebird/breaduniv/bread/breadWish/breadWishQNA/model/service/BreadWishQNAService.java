package com.firebird.breaduniv.bread.breadWish.breadWishQNA.model.service;

import com.firebird.breaduniv.bread.breadWish.breadWishQNA.model.dao.BreadWishQNADao;
import com.firebird.breaduniv.bread.breadWish.breadWishQNA.model.dto.BreadWishBoardDTO;
import org.springframework.stereotype.Service;

@Service
public class BreadWishQNAService {

    private final BreadWishQNADao breadWishQNADao;


    public BreadWishQNAService(BreadWishQNADao breadWishQNADao) {
        this.breadWishQNADao = breadWishQNADao;}

    /***
     *
     * @param boardCode
     * @return
     */

    public BreadWishBoardDTO selectBreadBoardInfo(int boardCode){

        BreadWishBoardDTO breadWishBoardDTO = breadWishQNADao.selectBreadBoardInfo(boardCode);
        System.out.println("breadWishBoard = " + breadWishBoardDTO);
        return breadWishBoardDTO;

    }
}


