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

	@Override
	public Teacher getTeacherById(Integer id) {
		return teacherRepository.findById(id).get();
		// .get() is required as findById(id) return is Optional 
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
 
		return teacherRepository.save(teacher);
	}

	@Override
	public void deleteTeacherById(Integer id) {
	
		teacherRepository.deleteById(id);
	}


}
