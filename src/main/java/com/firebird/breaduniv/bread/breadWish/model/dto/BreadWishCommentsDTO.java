package com.firebird.breaduniv.bread.breadWish.model.dto;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BreadWishCommentsDTO {

    private int commentsCode;
    private int boardCode;
    private int userCode;
    private String commentsContents;
    private String userName;
    private Date commentsDate;

    // userName 속성을 반환하는 getter 메서드 추가
    public String getUser() {
        return userName;
    }
}
