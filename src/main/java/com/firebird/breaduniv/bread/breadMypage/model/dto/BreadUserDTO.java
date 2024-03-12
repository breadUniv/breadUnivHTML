package com.firebird.breaduniv.bread.breadMypage.model.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.List;
@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BreadUserDTO implements UserDetails {

    private int userCode;
    private String userNumCode;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
    // 리스트로 가져올 때
//    private List<BreadFileDTO> breadFileDTOList;
}
