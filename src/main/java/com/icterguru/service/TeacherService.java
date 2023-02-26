package com.icterguru.service;

import java.util.List;

import com.icterguru.entity.Teacher;

public interface TeacherService {

	List<Teacher> getAllTeachers();

	Teacher getTeacherById(Integer id);
	
	Teacher saveTeacher(Teacher teacher);
	
	Teacher updateTeacher(Teacher teacher);
	
	void deleteTeacherById(Integer id);
	
}
