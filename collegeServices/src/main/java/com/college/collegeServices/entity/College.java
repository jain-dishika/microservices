package com.college.collegeServices.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    transient private List<Student> students;

//    public List<Student> getStudents(List<Student> students) {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//    }
}
