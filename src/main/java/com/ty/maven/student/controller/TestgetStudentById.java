package com.ty.maven.student.controller;

import com.ty.maven.student.dto.Student;
import com.ty.maven.student.service.StudentService;

public class TestgetStudentById {

	public static void main(String[] args) {

		StudentService service = new StudentService() ;
		Student student = service.getStudentById(1) ;
		
		System.out.println(student);

	}

}
