package com.example.realapi.service;

import com.example.realapi.model.Student;
import com.example.realapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

     public Optional<Student>  getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student updated) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        if (updated.getName() != null) existing.setName(updated.getName());
        if (updated.getAge() != null) existing.setAge(updated.getAge());
        if (updated.getEmail() != null) existing.setEmail(updated.getEmail());
        if (updated.getPassword() != null) existing.setPassword(updated.getPassword());
        if (updated.getPhone() != null) existing.setPhone(updated.getPhone());
        return studentRepository.save(existing);
    }
}
