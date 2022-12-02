package com.icterguru.service;

import java.util.List;

import javax.validation.Valid;

import com.icterguru.entity.Student;
import com.icterguru.error.StudentNotFoundException;

public interface IStudentService {

	public Student saveTheStudentRecord(Student std);

	public List<Student> fetchStudentList();
	public List<Student> getStudentList();

	public Student fetchAStudentRecordById(int stdId) throws StudentNotFoundException;
	public Student fetchAStudentRecordByName(String stdName);
	public Student fetchAStudentRecordByEmail(String stdEmail);

	public void deleteAStudentRecordById(int stdId);

	public Student updateAStudentRecordById(int stdId, Student std);

	public boolean saveStudentRecord(@Valid Student student);

	
	
	

}
