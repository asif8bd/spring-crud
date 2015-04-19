package com.asif.student.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import com.asif.student.model.Student;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource ds;
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public void setDataSource(DataSource ds) {
		this.ds = ds;
		this.jdbcTemplate = new JdbcTemplate(ds);

	}

	@Override
	public void create(String studentName, String studentEmail) {
		jdbcTemplate.update("insert into student(studentName, studentEmail) values ('"+studentName+"', '"+studentEmail+"')");

	}

	@Override
	public Student getStudents() {
		String SQL = "select studentId from student where studentId= (select MAX(studentId) from student )";
		Student student = jdbcTemplate.queryForObject(SQL, new StudentMapper());		
		return student;
	}

	@Override
	public List<Student> listStudents() {
		String SQL = "select * from student";
	    List <Student> students = jdbcTemplate.query(SQL, new StudentMapperAll());
	    return students;
	}

	@Override
	public void update(Integer studentId, String studentName,
			String studentEmail) {
		jdbcTemplate.update("update student set studentName ='"+studentName+"', studentEmail='"+studentEmail+"' where studentId ='"+studentId+"'");
		

	}
	@Override
	public void delete(Integer studentId) {
		jdbcTemplate.update("delete from student where studentId ='"+studentId+"'");
		

	}

}
