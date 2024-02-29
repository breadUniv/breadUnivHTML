package com.firebird.breaduniv.bread.breadWish.model.service;

import com.firebird.breaduniv.bread.breadWish.model.dao.BreadWishMapper;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishCommentsDTO;

import com.firebird.breaduniv.bread.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BreadWishServiceImpl implements BreadWishService {

    private final BreadWishMapper breadWishMapper;

    public BreadWishServiceImpl(BreadWishMapper breadWishMapper) {
        this.breadWishMapper = breadWishMapper;
    }

    @Override
    public BreadWishBoardDTO selectQNABoard(int boardCode) {
        return breadWishMapper.selectQNABoard(boardCode);
    }

    @Override
    public BreadWishBoardDTO selectSuggestionBoard(int boardCode) {
        return breadWishMapper.selectSuggestionBoard(boardCode);
    }

    @Override
    @Transactional // 매서드 내에서 실행되는 모든 데이터 베이스 작업은 단일 트랜잭션 내에서 실행
    // 트랜잭션은 데이터베이스 관리 시스템에서 여러개의 작업을 하나의 논리적인 작업 단위로 묶어서 처리하는 개념 즉 데이터베이스에서 데이터를 변경하는 작업을 수행 할 떄 사용
    // 작업 중 하나라도 실패하면 롤백됨
    public BreadWishBoardDTO selectQNAView(int boardCode) {

        BreadWishBoardDTO QNAView = null;
        // 만약 조회된 게시글이 존재하지 않거나 문제가 발생하면 null을 반환합니다.
        int result = breadWishMapper.viewCount(boardCode);
        // breadWishMapper의 viewCount 매서드를 호출하여 해당 boardCode에 대한 조회수를 가져옴
        if (result > 0) {
            QNAView = breadWishMapper.selectQNAView(boardCode);
            // 조회수가 존재하면 breadWishMapper의 selectQNAView 메서드를 호출하여 해당 boardCode에 대한 게시글 정보를 가져와 QNAView에 할당합니다.
        }

        log.info("[BreadWishServiceImpl] ===================== {}", QNAView);

        return QNAView;
    }

    @Override
    public BreadWishCommentsDTO selectComments(int commentsCode) {
        return breadWishMapper.selectComments(commentsCode);
    }

    @Override
    public BreadWishBoardDTO breadWishQNAPage(int boardCode) {
        return breadWishMapper.breadWishQNAPage(boardCode);
        // 여기에 breadWishQNAPage 메서드의 구현 추가
        // 이 메서드는 BreadWishService 인터페이스에서 추상 메서드로 선언되어 있습니다.
        // 실제 비즈니스 로직을 구현하여 해당 페이지의 데이터를 반환하도록 작성해야 합니다.
    }

    @Override
    public List<BreadWishBoardDTO> searchBoardByTitle(String searchValue) {
        return breadWishMapper.searchBoardByTitle(searchValue);
    }

    /**
     * 해당 게시글 전체 갯수 조회용 메소드
     * @param searchMap 검색용 객체
     * @return
     */
    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = breadWishMapper.selectTotalCount(searchMap);
        log.info("[BoardWishServiceImpl]  selectTotalCount ===================== {}", result);
        return result;

//        return breadWishMapper.selectTotalCount(searchMap);
    }

    /***
     * 게시글 전체 필터 조회용 메소드
     * @param selectCriteria
     * @return
     */
    @Override
    public List<BreadWishBoardDTO> selectBoardList(SelectCriteria selectCriteria) {

        List<BreadWishBoardDTO> BreadWishBoardDTOList = breadWishMapper.selectBoardList(selectCriteria);
        log.info("[BreadWishServiceImpl]  BreadWishBoardDTOList ===================== {}", BreadWishBoardDTOList);

        return BreadWishBoardDTOList;
    }

    /***
     * 게시글 상세 페이지 조회용 메소드
     * @param boardCode 게시글 번호
     * @return
     */
    @Override
    @Transactional
    public BreadWishBoardDTO selectBoardDetail(int boardCode) {
        BreadWishBoardDTO breadWishBoardDTO = null;

        int result = breadWishMapper.incrementBoardCount(boardCode);
        System.out.println("result =======================> " + result);

        if(result > 0) {
            breadWishBoardDTO = breadWishMapper.selectBoardDetail(boardCode);
        }

        log.info("[BreadWishServiceImpl-----------]  selectBoardDetail ===================== {}", breadWishBoardDTO);

        return breadWishBoardDTO;
    }

}

