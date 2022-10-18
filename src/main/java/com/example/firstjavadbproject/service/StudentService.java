package com.example.firstjavadbproject.service;

import com.example.firstjavadbproject.entity.Student;
import com.example.firstjavadbproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(long id) {
        Optional<Student> stdOp = studentRepository.findById(id);
        if (stdOp.isPresent()) {
            return stdOp.get();
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        Student std = this.getStudentById(student.getId());

        if (std != null) {
            return studentRepository.save(student);
        } else {
            return null;
        }
    }
}
