package com.firebird.breaduniv.breadProfessor.breadMypagePro.model.service;

import com.firebird.breaduniv.breadProfessor.breadMypagePro.model.dao.BreadMypageProDao;
import com.firebird.breaduniv.breadProfessor.breadMypagePro.model.dto.BreadMypageProDTO;
import org.springframework.stereotype.Service;

@Service
public class BreadMypageProService {

    private final BreadMypageProDao breadMypageProDao;

    public BreadMypageProService(BreadMypageProDao breadMypageProDao) {
        this.breadMypageProDao = breadMypageProDao;
    }

    public BreadMypageProDTO selectBreadMypageProInfo(int userCode) {

        BreadMypageProDTO breadMypageProDTO = breadMypageProDao.selectBreadMypageProInfo(userCode);

        System.out.println("[breadMypageProService] breadMypageProDTO result ======> " + breadMypageProDTO);

        return breadMypageProDTO;
    }
}
