package com.firebird.breaduniv.bread.breadMypage.model.dao;

import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadCourseRegistrationDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadEnrollmentDTO;
import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadMypageDao {
    BreadUserDTO selectBreadUserInfo(int userCode);
    BreadEnrollmentDTO selectBreadCourseInfo(int courseCode);

    BreadCourseRegistrationDTO selectBreadCourseRegistrationInfo(int courseRegistrationCode);

    int updateBread(BreadUserDTO breadUser);
}
