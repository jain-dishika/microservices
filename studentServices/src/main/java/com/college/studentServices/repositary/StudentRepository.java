package com.college.studentServices.repositary;

import com.college.studentServices.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByCollegeId(Long id);

    public void deleteByCollegeId(Long id);
}
