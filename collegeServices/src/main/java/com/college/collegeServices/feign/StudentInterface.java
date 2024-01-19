package com.college.collegeServices.feign;

import com.college.collegeServices.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "STUDENT-SERVICE", url = "http://localhost:8081/")
//@FeignClient(name = "user-service", )
public interface StudentInterface {
    @PostMapping("/students")
    public ResponseEntity<Student>  addStudents(@RequestBody Student student);

    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId);

    @GetMapping("/students/college/{collegeId}")
    public ResponseEntity<List<Student>> getAllStudents(@PathVariable Long collegeId);

    @DeleteMapping("students/college/{collegeId}")
    public void deleteStudentByCollegeId(@PathVariable Long collegeId);
}
