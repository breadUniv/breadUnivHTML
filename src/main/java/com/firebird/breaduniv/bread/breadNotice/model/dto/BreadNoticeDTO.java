package com.firebird.breaduniv.bread.breadNotice.model.dto;

import com.firebird.breaduniv.bread.breadMypage.model.dto.BreadUserDTO;
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
    private String boardTitle;
    private String boardContents;
    private String boardPostDate;
    private int boardViewCount;
    private String boardDeleteStatus;
    private String userName;

    private BreadUserDTO user;
    private BreadNoticeCategoryDTO category;
}
