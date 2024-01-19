package com.college.collegeServices.controller;

import com.college.collegeServices.entity.Student;
import com.college.collegeServices.entity.College;
import com.college.collegeServices.services.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    CollegeService collegeService;
//    @PostMapping
//    public ResponseEntity<College> add(@RequestBody College college){
//        return ResponseEntity.status(HttpStatus.CREATED).body(collegeService.addCollege(college));
//    }

    @GetMapping
    public ResponseEntity<List<College>> getAllCollege(){
        return ResponseEntity.ok().body(collegeService.getAllCollege());
    }

//    @DeleteMapping("{collegeId}")
//    public void deleteCollege(@PathVariable Long collegeId){
//        collegeService.deleteCollege(collegeId);
//        return;
//    }

    @GetMapping("{collegeId}")
    public College getCollegeById(@PathVariable Long collegeId){
        return collegeService.getCollegeById(collegeId);
    }

//    @PutMapping("{collegeId}")
//    public Student addStudentToCollege(@PathVariable Long collegeId,@RequestBody Student student){
//        return collegeService.addStudentToCollege(collegeId,student);
//    }
}
