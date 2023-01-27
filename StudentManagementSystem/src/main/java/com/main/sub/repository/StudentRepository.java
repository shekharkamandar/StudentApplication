package com.main.sub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.sub.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
