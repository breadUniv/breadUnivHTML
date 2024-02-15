package com.firebird.breaduniv.bread.breadMypage.model.dao;

import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadMypageDao {
    BreadUserDTO selectBreadUserInfo(int userId);
}
