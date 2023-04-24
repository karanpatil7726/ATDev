package com.spring.sc.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sc.entities.Student;
import com.spring.sc.exceptions.ResourceNotFoundException;
import com.spring.sc.payloads.StudentDto;
import com.spring.sc.repositories.StudentRepo;
import com.spring.sc.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;// To perform DB operations

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		Student student = this.modelMapper.map(studentDto, Student.class);
		Student addedStudent = this.studentRepo.save(student);
		return this.modelMapper.map(addedStudent, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, Integer studentId) {
		Student student = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", " Id ", studentId));

		student.setName(studentDto.getName());
		student.setCity(studentDto.getCity());
		student.setAge(studentDto.getAge());
		Student updatedStudent = this.studentRepo.save(student);
		return this.modelMapper.map(updatedStudent, StudentDto.class);
	}

	@Override
	public StudentDto getStudentById(Integer studentId) {
		Student student = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student ", " Id ", studentId));
		return this.modelMapper.map(student, StudentDto.class);

	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> studentsList = this.studentRepo.findAll();
		List<StudentDto> studentDtos = studentsList.stream()
				.map((Student) -> this.modelMapper.map(Student, StudentDto.class)).collect(Collectors.toList());
		return studentDtos;
	}

	@Override
	public void deleteStudent(Integer studentId) {
		Student student = this.studentRepo.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student ", " Id ", studentId));
		this.studentRepo.delete(student);

	}

}
