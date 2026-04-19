package com.placement.portal.service;

import com.placement.portal.model.Student;
import com.placement.portal.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public Student getStudentByUserId(Long userId) {
        return studentRepository.findByUser_Id(userId).orElse(null);
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
