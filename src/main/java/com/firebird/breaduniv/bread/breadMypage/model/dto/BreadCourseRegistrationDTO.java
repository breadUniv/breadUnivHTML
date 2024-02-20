package com.firebird.breaduniv.bread.breadMypage.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BreadCourseRegistrationDTO {
    private int courseRegistrationCode;
    private String userName;
    private String courseName;
    private String courseCompletionType;
    private String courseScheduleStartTime;
    private String courseScheduleEndTime;
    private String courseClassRoomName;
}
