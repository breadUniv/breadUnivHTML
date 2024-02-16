package com.firebird.breaduniv.bread.breadMypage.model.service;

import com.firebird.breaduniv.bread.breadMypage.model.dao.BreadMypageDao;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import org.springframework.stereotype.Service;

@Service
public class BreadMypageService {

    private final BreadMypageDao breadMypageDao;

    public BreadMypageService(BreadMypageDao breadMypageDao) {
        this.breadMypageDao = breadMypageDao;
    }

    /***
     * 사용자 정보 조회용 메소드
     * @param userCode 사용자 아이디
     * @return 사용자 전체 데이터
     */
    public BreadUserDTO selectBreadUserInfo(int userCode) {

        BreadUserDTO breadUserDTO = breadMypageDao.selectBreadUserInfo(userCode);

        System.out.println("[BreadMypageService] selectBreadUserInfo result ==== " + breadUserDTO);

        return breadUserDTO;
    }
}
