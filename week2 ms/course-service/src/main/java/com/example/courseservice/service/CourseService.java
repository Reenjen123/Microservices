package com.example.courseservice.service;

import com.example.courseservice.model.Course;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CourseService {
    private Map<String, Course> courseRepository = new HashMap<>();

    public Course addCourse(Course course) {
        courseRepository.put(course.getId(), course);
        return course;
    }

    public Course getCourseById(String id) {
        return courseRepository.get(id);
    }

    public Course updateCourse(String id, Course course) {
        courseRepository.put(id, course);
        return course;
    }

    public Course deleteCourse(String id) {
        return courseRepository.remove(id);
    }
}
