package com.asif.student.controller;

import javax.sql.DataSource;


import com.asif.student.model.Student;

import java.util.List;

public interface StudentDAO {
	
	public void setDataSource(DataSource ds);

	public void create(String studentName, String studentEmail);

	public Student getStudents();
	
	public List<Student> listStudents();
	
	public void update(Integer studentId, String studentName, String studentEmail);
	public void delete(Integer studentId);
	
}