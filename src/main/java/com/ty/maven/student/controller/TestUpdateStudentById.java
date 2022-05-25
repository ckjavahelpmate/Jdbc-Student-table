package com.ty.maven.student.controller;

import com.ty.maven.student.dto.Student;
import com.ty.maven.student.service.StudentService;

public class TestUpdateStudentById {

	
	public static void main(String[] args) {
		
		Student student = new Student() ;
		student.setName("Sheela");
		student.setCno("89784578");
		student.setEmail("sheela@mail.com");
		
		StudentService service = new StudentService() ;
		int res = service.updateStudentById(student,1) ;
		
		if( res != 0 ) System.out.println("Data inserted");
		else System.out.println("No data inserted");
	}

}
