package com.firebird.breaduniv.bread.breadNotice.model.service;

import com.firebird.breaduniv.bread.breadNotice.model.dao.BreadNoticeDao;
import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import com.firebird.breaduniv.bread.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
    public class BreadNoticeServiceImpl implements BreadNoticeService {

        private final BreadNoticeDao breadNoticeDao;

    public BreadNoticeServiceImpl(BreadNoticeDao breadNoticeDao) {
        this.breadNoticeDao = breadNoticeDao;
    }

    /**
     * 해당 게시글 전체 갯수 조회용 메소드
     * @param searchMap 검색용 객체
     * @return
     */
    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = breadNoticeDao.selectTotalCount(searchMap);
        log.info("[BoardServiceImpl]  selectTotalCount ===================== {}", result);

        return result;
    }

    /**
     * 게시글 전체 조회용 메소드
     * @param selectCriteria 조회용 객체
     * @return
     */
    @Override
    public List<BreadNoticeDTO> selectBoardList(SelectCriteria selectCriteria) {

        List<BreadNoticeDTO> breadNoticeDTOList = breadNoticeDao.selectBoardList(selectCriteria);
        log.info("[BreadNoticeServiceImpl]  breadNoticeDTOList ===================== {}", breadNoticeDTOList);

        return breadNoticeDTOList;
    }

    /**
     * 게시글 상세 페이지 조회용 메소드
     * @param boardCode 게시글 번호
     * @return
     */
    @Override
    @Transactional
    public BreadNoticeDTO selectBoardDetail(int boardCode) {
        BreadNoticeDTO breadNoticeDTO = null;

        int result = breadNoticeDao.incrementBoardCount(boardCode);

        if(result > 0) {
            breadNoticeDTO = breadNoticeDao.selectBoardDetail(boardCode);
        }

        log.info("[BoardServiceImpl]  selectBoardDetail ===================== {}", breadNoticeDTO);

        return breadNoticeDTO;
    }
}
