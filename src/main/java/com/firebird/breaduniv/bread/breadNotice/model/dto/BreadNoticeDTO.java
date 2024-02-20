package com.firebird.breaduniv.bread.breadNotice.model.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BreadNoticeDTO {

    private int boardCode;
    private int boardCategoryCode;
    private int userCode;
    private String boardTitle;
    private String boardContents;
    private Date boardPostDate;
    private int boardViewCount;
    private String boardDeleteStatus;

}
