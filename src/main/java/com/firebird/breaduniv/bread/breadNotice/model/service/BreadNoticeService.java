package com.firebird.breaduniv.bread.breadNotice.model.service;

import com.firebird.breaduniv.bread.breadNotice.model.dao.BreadNoticeDao;
import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import org.springframework.stereotype.Service;

@Service
public class BreadNoticeService {

    private final BreadNoticeDao breadNoticeDao;

    public BreadNoticeService(BreadNoticeDao breadNoticeDao) {
        this.breadNoticeDao = breadNoticeDao;

    }

    /**
     * 게시판 조회 메소드
     * @param boardCode 게시판 코드
     * @return 게시판 전체 정보
     */
    public BreadNoticeDTO selectBreadNoticeInfo(int boardCode) {

        BreadNoticeDTO breadNoticeDTO = breadNoticeDao.selectBreadNoticeInfo(boardCode);

        System.out.println("[BreadNoticeService] selectBreadNoticeInfo result =====> " + breadNoticeDTO);

        return breadNoticeDTO;
    }
}
