package com.icterguru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.icterguru.entity.Student;
import com.icterguru.entity.Teacher;
import com.icterguru.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired(required = true)
	private TeacherService teacherService;

	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}

	// Teacher Handlers handle the list of students and returns model and view

	@GetMapping("/teachers")
	public String getTeachers(Model model) {
		model.addAttribute("teachers", teacherService.getAllTeachers());

		return "teachers"; // returns the teachers.html file

	}

	// Teacher Handlers handle the list of students and returns model and view
//	@GetMapping("/teachers")
//	public String getTeachers(Model model) {
//		List<Teacher> teacherList = teacherService.getAllTeachers();
//		model.addAttribute("teacherList", teacherList);
//		return "teachers";	
//		// returns the teachers.html file 
//	}

	/*
	 * @CrossOrigin
	 * 
	 * @GetMapping("/teachers") public List<Teacher> fetchStudentList(){
	 * 
	 * return teacherService.getAllTeachers(); }
	 */

	@GetMapping("/teachers/addnew")
	public String newTeacher(Model model) {

		// This teacher will hold data from the Entry Form
		Teacher teacher = new Teacher();
		model.addAttribute("teachers", teacher);
		// returns the addnew_teachers.html file
		return "addnew_teacher";
	}

	@PostMapping(path = "/teachers")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {

		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
		// Will redirect the getTeachers()
	}

}
