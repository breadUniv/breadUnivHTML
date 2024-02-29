package com.firebird.breaduniv.bread.breadNotice.model.service;

import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
import com.firebird.breaduniv.bread.breadNotice.model.dao.BreadNoticeDao;
import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import com.firebird.breaduniv.bread.common.exception.NoticeModifyException;
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
     *
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
     *
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
     *
     * @param boardCode 게시글 번호
     * @return
     */
    @Override
    public BreadNoticeDTO selectBoardDetail(int boardCode) {
        BreadNoticeDTO breadNoticeDTO = null;

        int result = breadNoticeDao.incrementBoardCount(boardCode);
        System.out.println("result =======================> " + result);

        if (result > 0) {
            breadNoticeDTO = breadNoticeDao.selectBoardDetail(boardCode);
        }

        log.info("[BoardServiceImpl]  selectBoardDetail ===================== {}", breadNoticeDTO);

        return breadNoticeDTO;
    }

    /**
     * 게시글 등록용 메소드
     *
     * @param breadNoticeDTO 게시글 등록용 정보
     * @throws NoticeModifyException
     */
    @Override
    @Transactional
    public void registBoard(BreadNoticeDTO breadNoticeDTO) throws NoticeModifyException {

        int result = breadNoticeDao.insertBoard(breadNoticeDTO);
        System.out.println("result ====================> " + result);

        if (!(result > 0)) {
            throw new NoticeModifyException("게시글이 등록되지 않았습니다.");
        }
    }

    /**
     * 사용자 조회 메소드
     *
     * @param userCode
     * @return
     */
    @Override
    public BreadUserDTO selectUserInfo(int userCode) {
        BreadUserDTO breadUserDTO = null;
//        int result = breadNoticeDao.selectUserInfo(userCode);
        //System.out.println("result =======================> " + result);

        breadUserDTO = breadNoticeDao.selectUserInfo(userCode);

        return breadUserDTO;
    }


//    /**
//     * 공지사항 수정용 메소드
//     * @param noticeDTO
//     * @throws NoticeModifyException
//     */
//    @Override
//    @Transactional
//    public void breadNoticeModifyAdmin(BreadNoticeDTO noticeDTO) throws NoticeModifyException {
//
//        log.info("[NoticeServiceImpl] modifyNotice =================================== start");
//        int result = breadNoticeDao.insertBoard(noticeDTO);
//
//        log.info("[NoticeServiceImpl] modifyNotice =================================== result : {}", result);
//        log.info("[NoticeServiceImpl] modifyNotice =================================== end");
//
//        if (result > 0) {
//            throw new NoticeModifyException("공지사항 수정에 실패하였습니다.");
//        }
//    }
}
