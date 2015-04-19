package com.asif.student.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.asif.student.model.Student;

public class StudentMapperAll implements RowMapper<Student> {
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentId(rs.getString("studentId"));
		student.setStudentName(rs.getString("studentName"));
		student.setStudentEmail(rs.getString("studentEmail"));
		return student;
	}
}
