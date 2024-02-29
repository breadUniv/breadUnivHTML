package com.firebird.breaduniv.bread.breadWish.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BreadWishCategoryDTO {

    private int boardCategoryCode;
    private int boardUpperCategoryCode;
    private String categoryName;
}
