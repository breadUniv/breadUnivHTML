package com.firebird.breaduniv.bread.breadWish.model.dto;
import lombok.*;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BreadWishBoardDTO {

    private int boardCode;
    private int boardCategoryCode;
    private String boardTitle;
    private int userCode;
    private String boardContents;
    private int boardViewCount;
    private String boardPostDate;
    private String userName;
    private boolean boardDeleteStatus;
    private List<BreadWishCommentsDTO> comments;


//    public boolean getBoardDeleteStatus() {
//        return boardDeleteStatus;
//    }
}