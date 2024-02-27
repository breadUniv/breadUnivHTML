package com.firebird.breaduniv.bread.breadMypage.model.dao;

import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadCourseRegistrationDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadEnrollmentDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadFileDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadMypageDao {
    BreadUserDTO selectBreadUserInfo(int userCode);
    BreadEnrollmentDTO selectBreadCourseInfo(int courseCode);

    BreadCourseRegistrationDTO selectBreadCourseRegistrationInfo(int courseRegistrationCode);

    int updateBread(BreadUserDTO breadUser);

    int breadEditFileUpdate(BreadFileDTO breadFileDTO);

    int breadEditFileDelete(BreadFileDTO breadFileDTO);

    // 사용자 코드로 프로필 사진 정보 조회
    BreadFileDTO selectBreadUserFileInfo(int userCode);

}
