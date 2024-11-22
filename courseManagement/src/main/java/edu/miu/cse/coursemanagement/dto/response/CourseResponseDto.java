package edu.miu.cse.coursemanagement.dto.response;

import edu.miu.cse.coursemanagement.model.Course;

public record CourseResponseDto(
        String courseName,
        String courseCode
){

}
