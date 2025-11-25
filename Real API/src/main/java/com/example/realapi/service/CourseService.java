package com.example.realapi.service;

import com.example.realapi.model.Course;
import com.example.realapi.model.Student;
import com.example.realapi.repository.StudentRepository;
import com.example.realapi.request.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.*;

@Service
public class CourseService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> addCourseToStudent(Long studentId, CourseDto courseDto) {
        return studentRepository.findById(studentId).map(student ->
        {
            Course course = Course.builder().courseName(courseDto.getCourseName())
                    .description(courseDto.getDescription()).build();
            student.getCourses().add(course);
            return studentRepository.save(student);
        });
    }

    public Optional<List<Course>> getCoursesForStudent(Long studentId) {
        return studentRepository.findById(studentId).map(Student::getCourses);
    }

    public Optional<Student> removeCourseFromStudent(Long studentId, Long courseId) {
        return studentRepository.findById(studentId).map(student -> {
            student.getCourses().removeIf(course -> course.getId().equals(courseId));
            return studentRepository.save(student);
        });
    }

}
