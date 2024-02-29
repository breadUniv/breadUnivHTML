package com.firebird.breaduniv.bread.breadNotice.model.service;

import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import com.firebird.breaduniv.bread.breadNotice.model.dao.BreadNoticeDao;
import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import com.firebird.breaduniv.bread.common.exception.NoticeModifyException;
import com.firebird.breaduniv.bread.common.paging.SelectCriteria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BreadNoticeService {

    /* 해당 게시글 전체 갯수 조회용 메소드 */
    public int selectTotalCount(Map<String, String> searchMap);

    /* 게시글 전체 조회용 메소드 */
    public List<BreadNoticeDTO> selectBoardList(SelectCriteria selectCriteria);

    /* 게시글 상세 페이지 조회용 메소드 */
    public BreadNoticeDTO selectBoardDetail(int boardCode);

    /* 게시글 등록용 메소드 */
    public void registBoard(BreadNoticeDTO breadNoticeDTO) throws NoticeModifyException;

    /* 게시판에서 사용할 사용자 정보 조회 */
    public BreadUserDTO selectUserInfo(int userCode);

}
