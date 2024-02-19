package com.firebird.breaduniv.bread.breadWish.breadWishSuggestion.model.dto;


import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BreadWishBoard1DTO {

    private int boardCode;
    private int boardCategoryCode;
    private String boardTitle;
    private int userCode;
    private String boardContents;
    private int boardViewCount;
    private Date boardPostDate;
    private String userName;

    private boolean boardDeleteStatus;



}
