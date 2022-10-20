package com.example.firstjavadbproject.api;

import com.example.firstjavadbproject.dto.ResponseDTO;
import com.example.firstjavadbproject.entity.Student;
import com.example.firstjavadbproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentAPI {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseDTO getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/get-by-id/", method = RequestMethod.GET)
    public ResponseDTO getSingleStudent(@RequestParam(value = "stdId") long stdId) {

        return studentService.getStudentById(stdId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseDTO createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseDTO updateStudent(@RequestBody Student student) {

        return studentService.updateStudent(student);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseDTO deleteStudent(@PathVariable(name = "id") Long id) {

       return studentService.deleteStudent(id);
    }

}
