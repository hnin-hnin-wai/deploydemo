package edu.miu.cse.coursemanagement.controller;

import edu.miu.cse.coursemanagement.dto.request.CourseRequestDto;
import edu.miu.cse.coursemanagement.dto.response.CourseResponseDto;
import edu.miu.cse.coursemanagement.model.Course;
import edu.miu.cse.coursemanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public String createCourse(@ModelAttribute CourseRequestDto courseRequestDto) {
        courseService.createCourse(courseRequestDto);
        return "redirect:/api/v1/courses";//Redirect to path /api/v1/courses (request GET method)
    }

    @GetMapping
    public String getCourses(Model model) {
        //model.addAttribute("courses", courseService.getAllCourses());
       List<CourseResponseDto> courseResponseDtos = courseService.getAllCourses();
       model.addAttribute("courses", courseResponseDtos);
        return "result_page";
    }
}
