package com.icterguru.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icterguru.entity.Student;
import com.icterguru.error.StudentNotFoundException;
import com.icterguru.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public Student saveTheStudentRecord(Student std) {
		
		System.out.println("The record saved");
		return studentRepository.save(std);
	}
	
	@Override
	public boolean saveStudentRecord(@Valid Student student) {
		Student saveStudent = studentRepository.save(student);
		try {
			
			if(saveStudent != null) {
				return true;
			}else {
				return false;
			}
		}
		catch(Exception e){
		e.printStackTrace();	
		}
		return false;
	}
	

	@Override
	public List<Student> fetchStudentList() {

		return studentRepository.findAll();
	}

	@Override
	public List<Student> getStudentList() {
		return studentRepository.findAll();
	}

	@Override
	public Student fetchAStudentRecordById(int stdId) throws StudentNotFoundException{
//		return studentRepository.findById(stdId).get();
	Optional<Student> std =	studentRepository.findById(stdId);
	if (!std.isPresent()) {
		throw new StudentNotFoundException("Such a student with stdId = " + stdId + " is not available");
	}	
	
	return std.get();
	}

	@Override
	public Student fetchAStudentRecordByName(String stdName) {
		// TODO Auto-generated method stub
//		return departmentRepository.findByStdName(stdName);
		return studentRepository.findByStudentNameIgnoreCase(stdName);
	}

	@Override
	public Student fetchAStudentRecordByEmail(String stdEmail) {
	
//		return departmentRepository.findByStdName(stdName);
		return studentRepository.findByStudentEmail(stdEmail);
	}

		
	@Override
	public void deleteAStudentRecordById(int stdId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(stdId);
	}

	// 2:40
	@Override
	public Student updateAStudentRecordById(int stdId, Student student) {

		Student stdDB = studentRepository.findById(stdId).get();
		if (Objects.nonNull(student.getStudentName()) &&
				!"".equalsIgnoreCase(student.getStudentName())){
			stdDB.setStudentName(student.getStudentName());
		}

		if (Objects.nonNull(student.getStudentEmail()) &&
				!"".equalsIgnoreCase(student.getStudentEmail())){
			stdDB.setStudentEmail(student.getStudentEmail());
		}

		if (Objects.nonNull(student.getStudentPhone()) &&
				!"".equalsIgnoreCase(student.getStudentPhone())){
			stdDB.setStudentPhone(student.getStudentPhone());
		}


		if (Objects.nonNull(student.getStudentNotes()) &&
				!"".equalsIgnoreCase(student.getStudentNotes())){
			stdDB.setStudentNotes(student.getStudentNotes());
		}

		return studentRepository.save(stdDB);
	}
	// 2:40

	
	
}
