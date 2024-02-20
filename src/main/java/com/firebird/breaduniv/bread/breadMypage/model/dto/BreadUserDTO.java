package com.firebird.breaduniv.bread.breadMypage.model.dto;

import lombok.*;

import java.util.Date;

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
}
