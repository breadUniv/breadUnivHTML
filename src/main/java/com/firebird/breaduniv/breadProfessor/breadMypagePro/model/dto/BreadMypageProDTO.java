package com.firebird.breaduniv.breadProfessor.breadMypagePro.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BreadMypageProDTO {

    private int userCode;
    private String departmentName;
    private String departmentCode;
    private String userName;
    private String userPwd;
    private String userEmail;
    private Date userCreateDate;
    private String userAddress;
    private String userDetailedAddress;
    private String userPhone;
    private String userPermission;

    private int professorCode;
    private int professorAdmission;
    private int employmentCode;

    private String undergraduateName;

}
