package com.icterguru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

		return "teachers"; // returns to the the teachers.html file

	}

	@GetMapping("/teachers/addnew")
	public String returnsAddNewTeacherForm(Model model) {

		// This teachers bean will hold data from the Entry Form
		Teacher teacher = new Teacher();
		model.addAttribute("teachers", teacher);
		// returns to the the teacher_addnew.html file
		return "teacher_addnew";
	}

	@PostMapping(path = "/teachers")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {

		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
		// Will redirect the getTeachers()
	}

	@PostMapping(path = "/teachers/update/{id}")
	public String returnsUpdateTeacherForm(@PathVariable Integer id, Model model) {
		model.addAttribute("teacher", teacherService.getTeacherById(id));
		return "teacher_update";
		// returns to the the teacher_update.html file
	}

	@PostMapping(path = "/teachers/{id}")
	public String updateTeacherRecord(@PathVariable Integer id, Model model, @ModelAttribute("teacher") Teacher teacher) {
		// First get the teacher record from the database 
		Teacher updatesTeacher = teacherService.getTeacherById(id);
		updatesTeacher.setId(id);
		
		updatesTeacher.setLastName(teacher.getLastName() );
		updatesTeacher.setFirstName(teacher.getFirstName() );
		updatesTeacher.setEmail(teacher.getEmail() );
		updatesTeacher.setPhone(teacher.getPhone());
		updatesTeacher.setDepartment(teacher.getDepartment());
		updatesTeacher.setDesignation(teacher.getDesignation());
		updatesTeacher.setNotes(teacher.getNotes());
		
		teacherService.updateTeacher(teacher);
		return "redirect:/teachers";
	}
	
	// Delete a record handler by id
	
	public String deleteTeacherRecord(@PathVariable Integer id) {
		teacherService.deleteTeacherById(id);
		return "redirect:/teachers";
	}
}
