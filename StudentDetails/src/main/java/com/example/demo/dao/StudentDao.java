package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

import ch.qos.logback.core.model.Model;
@Repository
public class StudentDao {
	@Autowired
	JdbcTemplate tem;
	public void save(Student std) {
		String sql = "insert into student values(?,?,?,?)";
		tem.update(sql, std.getStudent_id(),std.getStudent_name(), std.getCourse_name(), std.getStudent_email());
		
	}
	public void delete(int student_id) {
		String sql = "DELETE FROM student WHERE student_id = ?";
		tem.update(sql,student_id);
	}
	
	public void edit(Student std) {
		String sql = "UPDATE student SET student_name = ?, course_name = ?, student_email = ? WHERE student_id = ?";
		tem.update(sql, std.getStudent_name(), std.getCourse_name(), std.getStudent_email(), std.getStudent_id());
	}
	
	public List<Student> display(){
		String sql = "SELECT * FROM student ";
		return tem.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
	}
	 public Student getStudent(int student_id) {
		 String sql = "SELECT * FROM student where student_id = ?";
		 return tem.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), student_id);
	 }
}
