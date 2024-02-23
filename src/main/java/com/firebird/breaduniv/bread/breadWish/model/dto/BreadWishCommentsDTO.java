package com.firebird.breaduniv.bread.breadWish.model.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BreadWishCommentsDTO {

    private int commentsCode;
    private int board_Code;
    private int boardCategoryCode;
    BreadWishBoardDTO board;
    private int boardCode;
    private String commentsContents;
    private String userName;

    public BreadWishCommentsDTO(int board_code, int boardCategory_code, String comments_contents, String userName ) {
        this.boardCode = board_code;
        this.boardCategoryCode = boardCategory_code;
        this.commentsContents = comments_contents;
        this.userName = userName;

    }
}
