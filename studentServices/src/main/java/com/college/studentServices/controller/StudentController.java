package com.college.studentServices.controller;

import com.college.studentServices.Service.StudentService;
import com.college.studentServices.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudents(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId){
        return ResponseEntity.ok().body(studentService.getStudentById(studentId));
    }

    @GetMapping("/college/{collegeId}")
    public ResponseEntity<List<Student>> getAllStudents(@PathVariable Long collegeId){
        return ResponseEntity.ok().body(studentService.getAllStudent(collegeId));
    }

    @DeleteMapping("/college/{collegeId}")
    public void deleteStudentByCollegeId(@PathVariable Long collegeId){
        studentService.deleteStudentByCollegeId(collegeId);
        return ;
    }

}
