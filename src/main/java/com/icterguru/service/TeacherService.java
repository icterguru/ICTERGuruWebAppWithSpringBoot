package com.icterguru.service;

import java.util.List;

import com.icterguru.entity.Teacher;

public interface TeacherService {

	List<Teacher> getAllTeachers();

	Teacher saveTeacher(Teacher teacher);


}