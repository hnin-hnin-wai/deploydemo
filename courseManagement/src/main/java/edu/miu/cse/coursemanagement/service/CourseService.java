package edu.miu.cse.coursemanagement.service;

import edu.miu.cse.coursemanagement.dto.request.CourseRequestDto;
import edu.miu.cse.coursemanagement.dto.response.CourseResponseDto;
import edu.miu.cse.coursemanagement.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<CourseResponseDto> createCourse(CourseRequestDto courseRequestDto);
    List<CourseResponseDto> getAllCourses();
}
