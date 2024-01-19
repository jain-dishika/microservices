package com.college.collegeServices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Student {

    private Long Id;

    private String name;

    private String email;

    private Long collegeId;
}
