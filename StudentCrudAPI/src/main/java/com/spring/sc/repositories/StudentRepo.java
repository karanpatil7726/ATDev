package com.spring.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.sc.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
