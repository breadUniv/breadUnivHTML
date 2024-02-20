package com.firebird.breaduniv.bread.breadNotice.model.dao;

import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadNoticeDao {

    BreadNoticeDTO selectBreadNoticeInfo(int boardCode);
}
