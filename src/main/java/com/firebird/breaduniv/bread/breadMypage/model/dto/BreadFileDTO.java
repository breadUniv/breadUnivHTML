package com.firebird.breaduniv.bread.breadMypage.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BreadFileDTO {
    private int fileCode;
    private int boardCode;
    private String fileOriginalFileName;
    private String fileUploadName;
    private String fileType;
    private boolean fileDeleteStatus;

//    public BreadFileDTO(String fileOriginalFileName, String fileUploadName) {
//        this.fileOriginalFileName = fileOriginalFileName;
//        this.fileUploadName = fileUploadName;
//    }
}
