package com.firebird.breaduniv.bread.breadNotice.model.dao;

import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import com.firebird.breaduniv.bread.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BreadNoticeDao {

    int selectTotalCount(Map<String, String> searchMap);

    int incrementBoardCount(int boardViewCount);

    BreadNoticeDTO selectBoardDetail(int boardCode);

    List<BreadNoticeDTO> selectBoardList(SelectCriteria selectCriteria);

    int insertBoard(BreadNoticeDTO noticeDTO);

    BreadUserDTO selectUserInfo(int userCode);
}
