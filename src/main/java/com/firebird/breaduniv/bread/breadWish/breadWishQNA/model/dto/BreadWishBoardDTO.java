package com.firebird.breaduniv.bread.breadWish.breadWishQNA.model.dto;


import lombok.*;

import java.util.Date;

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
    private Date boardPostDate;
    private String userName;

    private boolean boardDeleteStatus;

    public boolean getBoardDeleteStatus() {
        return boardDeleteStatus;
    }

    public void setBoardDeleteStatus(boolean boardDeleteStatus) {
        this.boardDeleteStatus = boardDeleteStatus;
    }
}

