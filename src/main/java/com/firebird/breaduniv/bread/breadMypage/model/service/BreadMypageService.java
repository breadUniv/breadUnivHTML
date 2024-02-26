package com.firebird.breaduniv.bread.breadMypage.model.service;

import com.firebird.breaduniv.bread.breadMypage.model.dao.BreadMypageDao;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadCourseRegistrationDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadEnrollmentDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadFileDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        System.out.println("[BreadMypageService] selectBreadUserInfo result =====> " + breadUserDTO);
        return breadUserDTO;
    }

    public BreadEnrollmentDTO selectBreadCourseInfo(int courseCode) {
        BreadEnrollmentDTO breadEnrollmentDTO = breadMypageDao.selectBreadCourseInfo(courseCode);
        System.out.println("[BreadMypageService] selectBreadCourseInfo result =====> " + breadEnrollmentDTO);
        return breadEnrollmentDTO;
    }

    public BreadCourseRegistrationDTO selectBreadCourseRegistrationInfo(int courseRegistrationCode) {
        BreadCourseRegistrationDTO breadCourseRegistrationDTO = breadMypageDao.selectBreadCourseRegistrationInfo(courseRegistrationCode);
        System.out.println("[BreadMypageService] selectBreadCourseInfo result =====> " + breadCourseRegistrationDTO);
        return breadCourseRegistrationDTO;
    }

    @Transactional
    public int updateBread(BreadUserDTO breadUser) {
        int result = 0;
        result = breadMypageDao.updateBread(breadUser);
        System.out.println("result = " + result);
        return result;
    }

    @Transactional
    public int breadEditFileUpdate(BreadFileDTO breadFileDTO) {
        int result = breadMypageDao.breadEditFileUpdate(breadFileDTO);
        System.out.println("result = " + result);
        return result;
    }

    @Transactional
    public int breadEditFileDelete(BreadFileDTO breadFileDTO) {
        int result = breadMypageDao.breadEditFileDelete(breadFileDTO);
        System.out.println("result = " + result);
        return result;
    }

    public String getOriginFileNameByUserCode(int userCode) {
        // userCode에 해당하는 사용자 조회
        BreadFileDTO userFile = breadMypageDao.selectBreadUserFileInfo(userCode);
        if (userFile != null) {
            // 사용자가 존재하면 프로필의 originFileName 반환
            return userFile.getProfileUploadFileName();
        } else {
            // 사용자가 존재하지 않으면 예외 처리 또는 기본값 반환
            return null;
        }
    }
}
