package com.firebird.breaduniv.breadProfessor.breadMypagePro.model.dao;

import com.firebird.breaduniv.breadProfessor.breadMypagePro.model.dto.BreadMypageProDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadMypageProDao {

    BreadMypageProDTO selectBreadMypageProInfo(int userCode);

}
