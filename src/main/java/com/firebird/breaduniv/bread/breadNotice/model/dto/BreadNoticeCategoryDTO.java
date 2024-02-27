package com.firebird.breaduniv.bread.breadNotice.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BreadNoticeCategoryDTO {

    private int boardCategoryCode;
    private int boardUpperCategoryCode;
    private String categoryName;
}
