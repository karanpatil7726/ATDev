package com.spring.sc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sc.payloads.ApiResponse;
import com.spring.sc.payloads.StudentDto;
import com.spring.sc.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// POST - create student
	@PostMapping("/")
	ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
		StudentDto createStudent = this.studentService.createStudent(studentDto);
		return new ResponseEntity<>(createStudent, HttpStatus.CREATED);

	}

	// PUT - update student
	@RequestMapping("/{studentId}")
	ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable Integer studentId) {
		StudentDto updatedStudent = this.studentService.updateStudent(studentDto, studentId);
		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	}

//	DELETE - delete student
	@DeleteMapping("/{studentId}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("studentId") Integer sId) {
		this.studentService.deleteStudent(sId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Student deleted successfully", true), HttpStatus.OK);
	}

//	GET ALL - get all students
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		List<StudentDto> allStudents = this.studentService.getAllStudents();
		return ResponseEntity.ok(allStudents);
	}

//	GET - get student by id
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer studentId) {
		StudentDto studentById = this.studentService.getStudentById(studentId);
		return ResponseEntity.ok(studentById);
	}
}
