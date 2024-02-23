package com.firebird.breaduniv.bread.breadMypage.model.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BreadUserDTO {
    // 마이페이지
    private int userCode;
    private String departmentCode;
    private String userName;
    private String userPwd;
    private String userEmail;
    private Date userCreateDate;
    private String userAddress;
    private String userDetailedAddress;
    private String userPhone;
    private String userPermission;
    private String studentCode;
    private int studentGrade;
    private int academicStatusCode;
    private int studentAdmission;
    private String departmentName;
    private String undergraduateName;

    private BreadFileDTO breadFile;
    // 리스트로 가져올 때
//    private List<BreadFileDTO> breadFileDTOList;
}
