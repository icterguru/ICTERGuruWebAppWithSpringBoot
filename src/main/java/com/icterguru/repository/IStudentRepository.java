package com.icterguru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icterguru.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{

	public Student findByStudentName(String studentName);
	
	public Student findByStudentNameIgnoreCase(String studentName);
	public Student findByStudentEmail(String studentEmail);
	
	
}




