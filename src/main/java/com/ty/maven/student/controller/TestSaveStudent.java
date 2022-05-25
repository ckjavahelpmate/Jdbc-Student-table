package com.ty.maven.student.controller;

import com.ty.maven.student.dto.Student;
import com.ty.maven.student.service.StudentService;

public class TestSaveStudent {

	
	public static void main(String[] args) {
		
		Student student = new Student() ;
		student.setSid(1);
		student.setName("Shobha");
		student.setCno("9071864676");
		student.setEmail("shobha@mail.com");
		
		StudentService service = new StudentService() ;
		int res = service.saveStudent(student) ;
		
		if( res != 0 ) System.out.println("Data inserted");
		else System.out.println("No data inserted");
	}

}
