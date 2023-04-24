package com.spring.sc.services;

import java.util.List;

import com.spring.sc.payloads.StudentDto;

public interface StudentService {

	StudentDto createStudent(StudentDto student);

	StudentDto updateStudent(StudentDto student,Integer studentId);

	StudentDto getStudentById(Integer studentId);

	List<StudentDto> getAllStudents();

	void deleteStudent(Integer studentId);
}
