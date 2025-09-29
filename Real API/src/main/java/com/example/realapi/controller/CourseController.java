package com.example.realapi.controller;

import com.example.realapi.model.Course;
import com.example.realapi.model.Student;
import com.example.realapi.request.CourseDto;
import com.example.realapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/api/student/{id}/courses")
    public ResponseEntity<Student> addCourseToStudent(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        return courseService.addCourseToStudent(id, courseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/student/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesForStudent(@PathVariable Long id) {
        return courseService.getCoursesForStudent(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/api/student/{id}/courses/{courseId}")
    public ResponseEntity<Student> removeCourseFromStudent(@PathVariable Long id, @PathVariable Long courseId) {
        return courseService.removeCourseFromStudent(id, courseId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
