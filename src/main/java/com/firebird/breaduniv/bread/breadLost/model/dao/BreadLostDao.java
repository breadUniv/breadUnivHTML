package com.firebird.breaduniv.bread.breadLost.model.dao;

import com.firebird.breaduniv.bread.breadLost.model.dto.BreadLostDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BreadLostDao {

    BreadLostDTO selectBreadLostInfo(int boardCode);
}
