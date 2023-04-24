package com.spring.sc.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class StudentDto {
	private int id;
	private String name;
	private String city;
	private int age;
	
}
