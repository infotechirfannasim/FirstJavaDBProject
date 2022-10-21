package com.example.firstjavadbproject.service;

import com.example.firstjavadbproject.dto.ResponseDTO;
import com.example.firstjavadbproject.entity.Student;
import com.example.firstjavadbproject.repository.StudentRepository;
import com.example.firstjavadbproject.util.AppUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseDTO getStudentById(long id) {
        //Optional<Student> stdOp = studentRepository.findById(id);
        ResponseDTO responseDTO = new ResponseDTO();
        Optional<Student> stdOp = studentRepository.findById(id);
        if (stdOp.isPresent()) {
            responseDTO.setMessage(AppUtility.getResourceMessage("student.found.success"));
            responseDTO.setData(stdOp.get());
        } else {
            responseDTO.setMessage(AppUtility.getResourceMessage("student.not.found"));
        }
        return responseDTO;
    }

    public ResponseDTO getAllStudents() {
        //return studentRepository.findAll();
        ResponseDTO responseDTO = new ResponseDTO();
        List<Student> students = studentRepository.findAll();
        if (students.size() > 0) {
            responseDTO.setMessage(AppUtility.getResourceMessage("student.found.success"));
            responseDTO.setData(students);
        } else {
            responseDTO.setMessage(AppUtility.getResourceMessage("student.not.found"));
        }
        return responseDTO;
    }

    public ResponseDTO createStudent(Student student) {
        ResponseDTO responseDTO = new ResponseDTO();
        Student std = studentRepository.save(student);
        if (std != null) {
            responseDTO.setMessage(AppUtility.getResourceMessage("student.create.success"));
            responseDTO.setData(std);
        } else {
            responseDTO.setMessage(AppUtility.getResourceMessage("student.create.error"));
        }
        return responseDTO;
    }

    public ResponseDTO createStudentWithPhoto(Student student, MultipartFile photo) throws IOException {
        ResponseDTO responseDTO = new ResponseDTO();
        if (photo != null) {
            student.getProfile().setPhoto(photo.getBytes());
        }
        Student std = studentRepository.save(student);
        if (std != null) {
            responseDTO.setMessage(AppUtility.getResourceMessage("student.create.success"));
            responseDTO.setData(std);
        } else {
            responseDTO.setMessage(AppUtility.getResourceMessage("student.create.error"));
        }
        return responseDTO;
    }

    public ResponseDTO updateStudent(Student student) {
        Optional<Student> std = studentRepository.findById(student.getId());

        ResponseDTO responseDTO = new ResponseDTO();
        if (std.isPresent()) {
            studentRepository.save(student);
            responseDTO.setMessage(AppUtility.getResourceMessage("student.update.success"));
            responseDTO.setData(student);
        } else {
            responseDTO.setMessage(AppUtility.getResourceMessage("student.not.found"));
        }
        return responseDTO;
    }

    public ResponseDTO deleteStudent(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        Optional<Student> std = studentRepository.findById(id);
        if (std.isPresent()) {
            studentRepository.delete(std.get());
            responseDTO.setMessage(AppUtility.getResourceMessage("student.delete.success"));
            responseDTO.setData(null);
        } else {
            responseDTO.setMessage(AppUtility.getResourceMessage("student.not.found"));
        }
        return responseDTO;
    }
}
