package com.ty.maven.student.service;

import static com.ty.maven.student.util.AppConstants.KEY;

import com.ty.maven.student.dao.StudentDao;
import com.ty.maven.student.dto.Student;
import com.ty.maven.student.util.AES;

public class StudentService {
	StudentDao dao = new StudentDao() ;
	
	public int saveStudent(Student student) {
		
		String encCno = AES.encrypt(student.getCno(), KEY) ;
		student.setCno(encCno);
		return dao.saveStudent(student) ;	
	}
	public int updateStudentById(Student student,int id) {
		
		String encCno = AES.encrypt(student.getCno(), KEY) ;
		student.setCno(encCno);
		return dao.updateStudentById(student, id) ;	
	}
	public int deleteStudentById(int id) {
		
		return dao.deleteStudentById(id) ;	
	
	}
	public Student getStudentById(int id) {
		Student student = dao.getStudentById(id) ;
		
		String decCon = AES.decrypt(student.getCno(), KEY) ;
		student.setCno(decCon);
		
		return student ;
	}
	
}
