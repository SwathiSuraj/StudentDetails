package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Controller
public class StudentController {
	@Autowired
	StudentDao sd;
	@GetMapping("/studentform")
	public String studentDetails() {
		
		return "studentform";
	}
	 
	
	@PostMapping("/save")
	public String save(Student stu) {
		sd.save(stu);
		return "redirect:/submit";
	}
	
	@GetMapping("/delete/{student_id}")
	public String delete(@PathVariable int student_id) {
		sd.delete(student_id);
		return "redirect:/submit";
	}
	
	@GetMapping("/edit/{student_id}")
	public String editStudent(@PathVariable int student_id, Model m) {
		Student student = sd.getStudent(student_id);
		m.addAttribute("student", student);
		m.addAttribute("submit","edit");
		return "edit";
	}
	@PostMapping("/update")
	public String updateDetails(Student std) {
		sd.edit(std);
		return "redirect:/submit";
		
	}
	@GetMapping("/submit")
	public String listDetails(Model model) {
		List<Student> li = sd.display();
		model.addAttribute("submit",li);
		return "submit";
	}

}
