package com.college.collegeServices.services;

import com.college.collegeServices.entity.College;
import com.college.collegeServices.entity.Student;
import com.college.collegeServices.feign.StudentInterface;
import com.college.collegeServices.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private StudentInterface studentInterface;

    @Autowired
    CollegeRepository collegeRepo;
    public College addCollege(College college) {
        List<Student> students = new ArrayList<>();
        College dummyCollege = collegeRepo.save(college);
        for (Student student:college.getStudents()){
            student.setCollegeId(dummyCollege.getId());
            Student newstudent=studentInterface.addStudents(student).getBody();
            students.add(newstudent);
        }
        college.setStudents(students);
        return collegeRepo.save(college);
    }

    public List<College> getAllCollege() {
        List<College> colleges = collegeRepo.findAll();
        for(College college:colleges){
            college.setStudents(studentInterface.getAllStudents(college.getId()).getBody());
        }
        return colleges;
    }

    public College getCollegeById(Long collegeId){
        List<Student> students = studentInterface.getAllStudents(collegeId).getBody();
        College college = collegeRepo.findById(collegeId).get();
        college.setStudents(students);
        return college;
    }


    public void deleteCollege(Long collegeId) {
        College college = getCollegeById(collegeId);
        for (Student student:college.getStudents()){
            studentInterface.deleteStudentByCollegeId(collegeId);
        }
        collegeRepo.delete(college);
    }

    public Student addStudentToCollege(Long collegeId,Student student){
        College college = getCollegeById(collegeId);
        student.setCollegeId(college.getId());
        Student newstudent=studentInterface.addStudents(student).getBody();
        college.getStudents().add(newstudent);
        return newstudent;
    }
}
