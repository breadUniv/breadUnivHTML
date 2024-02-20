package com.firebird.breaduniv.bread.breadLost.model.service;

import com.firebird.breaduniv.bread.breadLost.model.dao.BreadLostDao;
import com.firebird.breaduniv.bread.breadLost.model.dto.BreadLostDTO;
import org.springframework.stereotype.Service;

@Service
public class BreadLostService {

    private final BreadLostDao breadLostDao;

    public BreadLostService(BreadLostDao breadLostDao) {
        this.breadLostDao = breadLostDao;
    }

    /***
     *
     * @param boardCode 게시판 코드
     * @return 게시판 전체 정보
     */
    public BreadLostDTO selectBreadLostInfo(int boardCode) {

        BreadLostDTO breadLostDTO = breadLostDao.selectBreadLostInfo(boardCode);

        System.out.println("[BreadLostService] selectBreadLostInfo result =========> " + breadLostDTO);

        return breadLostDTO;

    }
}
