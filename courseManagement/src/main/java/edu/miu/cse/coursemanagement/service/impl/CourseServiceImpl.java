package edu.miu.cse.coursemanagement.service.impl;

import edu.miu.cse.coursemanagement.dto.request.CourseRequestDto;
import edu.miu.cse.coursemanagement.dto.response.CourseResponseDto;
import edu.miu.cse.coursemanagement.model.Course;
import edu.miu.cse.coursemanagement.repository.CourseRepository;
import edu.miu.cse.coursemanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Optional<CourseResponseDto> createCourse(CourseRequestDto courseRequestDto) {
        Course course = new Course(
                courseRequestDto.courseName(),
                courseRequestDto.courseCode(),
                courseRequestDto.courseDescription());
        Course savedCourse = courseRepository.save(course);
        CourseResponseDto courseResponseDto=new CourseResponseDto(
                savedCourse.getCourseName(),
                savedCourse.getCourseCode()
        );
        return Optional.of(courseResponseDto);
    }

    @Override
    public List<CourseResponseDto> getAllCourses() {
        List<Course> courses=courseRepository.findAll();
        List<CourseResponseDto> courseResponseDtos=new ArrayList<>();
        for(Course course:courses){
            CourseResponseDto courseResponseDto=new CourseResponseDto(
                    course.getCourseName(),
                    course.getCourseCode());
                    courseResponseDtos.add(courseResponseDto);


        }
        return courseResponseDtos;
    }
}
