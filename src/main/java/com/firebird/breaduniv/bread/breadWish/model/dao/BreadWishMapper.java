package com.firebird.breaduniv.bread.breadWish.model.dao;

import com.firebird.breaduniv.bread.breadNotice.model.dto.BreadNoticeDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishBoardDTO;
import com.firebird.breaduniv.bread.breadWish.model.dto.BreadWishCommentsDTO;
import com.firebird.breaduniv.bread.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BreadWishMapper {

    BreadWishBoardDTO selectQNABoard(int boardCode);

    BreadWishBoardDTO selectSuggestionBoard(int boardCode);

    BreadWishBoardDTO selectQNAView(int boardCode);
    //selectQNAView 메서드는 조회만을 목적으로 하고, 결과를 반환할 필요가 없으면 BreadWishBoardDTO -> void로 변경해서 씀

    BreadWishCommentsDTO selectComments(int commentsCode);

    int viewCount(int boardCode);

    BreadWishBoardDTO breadWishQNAPage(int boardCode);
    List<BreadWishBoardDTO> searchBoardByTitle(String searchValue);

    int selectTotalCount(Map<String, String> searchMap);
    List<BreadWishBoardDTO> selectBoardList(SelectCriteria selectCriteria);
    BreadWishBoardDTO selectBoardDetail(int boardCode);
    int incrementBoardCount(int boardViewCount);
}


