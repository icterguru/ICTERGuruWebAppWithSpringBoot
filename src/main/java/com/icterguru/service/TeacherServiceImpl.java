package com.icterguru.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icterguru.entity.Teacher;
import com.icterguru.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	
	private TeacherRepository  teacherRepository; 
	
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	
	}

	@Override
	public Teacher saveTeacher(Teacher teacher) {

		return teacherRepository.save(teacher);
		
	}

	
}
