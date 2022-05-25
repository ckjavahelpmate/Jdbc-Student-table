package com.ty.maven.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.maven.student.dto.Student;
import com.ty.maven.student.util.ConnectionObject;

public class StudentDao {
	public int saveStudent(Student student) {
		Connection connection = ConnectionObject.getConnection() ;
		String sql = "insert into student values(?,?,?,?)" ;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
			preparedStatement.setInt(1, student.getSid());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getCno());
			preparedStatement.setString(4, student.getEmail());

			return preparedStatement.executeUpdate() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int updateStudentById(Student student,int id) {
		Connection connection = ConnectionObject.getConnection() ;
		String sql = "update student set name=?,cno=?,email=? where sid=?" ;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
			preparedStatement.setInt(4, id);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getCno());
			preparedStatement.setString(3, student.getEmail());
			
			return preparedStatement.executeUpdate() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int deleteStudentById(int id) {
		Connection connection = ConnectionObject.getConnection() ;
		String sql = "delete from student where id=?" ;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
			preparedStatement.setInt(1, id);	
			return preparedStatement.executeUpdate() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public Student getStudentById(int id) {
		Connection connection = ConnectionObject.getConnection() ;
		String sql = "select * from student where sid=?" ;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery() ;
			Student student = new Student() ;
			while(resultSet.next()) {
				
				student.setSid(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setCno(resultSet.getString(3));
				student.setEmail(resultSet.getString(4));
				
				return student ;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null ;
	}
}
