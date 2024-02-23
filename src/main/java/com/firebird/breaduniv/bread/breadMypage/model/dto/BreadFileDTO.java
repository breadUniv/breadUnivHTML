package com.firebird.breaduniv.bread.breadMypage.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BreadFileDTO {
    private int profileCode;
    private int userCode;
    private String profileOriginFileName;
    private String profileUploadFileName;
    private String profileDeleteStatus;

}
