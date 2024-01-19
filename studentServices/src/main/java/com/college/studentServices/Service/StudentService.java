package com.college.studentServices.Service;

import com.college.studentServices.entity.Student;
import com.college.studentServices.repositary.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public Student addStudent(Student student){
       return studentRepo.save(student);
    }

    public Student getStudentById(Long studentId) {
        return studentRepo.findById(studentId).get();
    }

    public List<Student> getAllStudent(Long collegeId) {
        return studentRepo.findByCollegeId(collegeId);
    }

    public void deleteStudentByCollegeId(Long collegeId) {
        List<Student> students = studentRepo.findByCollegeId(collegeId);
        for (Student student : students){
            studentRepo.delete(student);
        }
    }

}
