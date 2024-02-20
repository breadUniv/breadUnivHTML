package com.firebird.breaduniv.bread.breadLost.model.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BreadLostDTO {
    private int boardCode;
    private int boardCategoryCode;
    private int userCode;
    private String boardTitle;
    private String boardContents;
    private Date boardPostDate;
    private int boardViewCount;
    private String boardDeleteStatus;
}
