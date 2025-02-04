package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.crud.entity.Student;
import com.example.crud.service.StudentService;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;


    @GetMapping

    public List<Student> getAll(){
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")

    public Optional<Student> getById(@PathVariable("studentId") Long studentId){
        return studentService.getStudent(studentId);
    }

    @PostMapping

    public void saveUpdate(@RequestBody Student student){
         studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{studentId}")

    public void saveUpdate(@PathVariable("studentId") Long studentId){
         studentService.delete(studentId);
    }
}
