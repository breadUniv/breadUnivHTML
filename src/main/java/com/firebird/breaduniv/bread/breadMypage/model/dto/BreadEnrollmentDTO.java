package com.firebird.breaduniv.bread.breadMypage.model.dto;

import lombok.*;

import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BreadEnrollmentDTO {
    private String courseCode;
    private String classRoomName;
    private String userName;
    private String courseName;
    private String courseCompletionType;
    private int courseCapacity;
    private String creditSemester;

    private String courseScheduleStartTime;
    private String courseScheduleEndTime;
}
