package com.icterguru.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icterguru.entity.Student;
import com.icterguru.error.StudentNotFoundException;
import com.icterguru.service.IStudentService;

@RestController
@RequestMapping(path="/")
public class StudentController {


	//@Autowired // Property-based Autowire (dependency injection)
	@Autowired(required=true)
	private IStudentService stdService;
	
	private final Logger LOGGER = 
			LoggerFactory.getLogger(StudentController.class);
	
	// 2:13 Minute
	// 1:23:23 Minute of Session 14
	
	@CrossOrigin
	@PostMapping(path ="/savethestudent", consumes= MediaType.APPLICATION_JSON_VALUE)
	public Student saveTheStudentRecord(@Valid @RequestBody Student student) {
		LOGGER.info("In side the StudentController.saveTheStudentRecord() method");
		return stdService.saveTheStudentRecord(student); 
	}
	
	// At 1:37 Session 14
	@CrossOrigin
//	//@RequestMapping(method = RequestMethod.POST, path = "/savestudent", consumes= MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(path = "/savestudent", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveStudentRecord(@Valid @RequestBody Student student) {
		//		StudentService service = new DepartmentServiceImpl();
		LOGGER.info("In side the StudentController.saveStudentRecord() method");
		if (stdService.saveStudentRecord(student)) {
			return new ResponseEntity<>("Succeeded to save Student record", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Failed to save Student record", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	 
	}
	

	@CrossOrigin
	@GetMapping(path = "/getstudentlist")
	public ResponseEntity<List<Student>> getStudentList(){
		
		LOGGER.info("Inside the StudentController.getStudentList() method");
		
		return new ResponseEntity<>(stdService.getStudentList(), HttpStatus.OK); 	
	}
	
	@CrossOrigin
	@GetMapping("/students")
	public List<Student> fetchStudentList(){
		
		LOGGER.info("In side the StudentController.fetchStudentList() method");
		
		return stdService.fetchStudentList(); 	
	}
	
	@CrossOrigin
	@GetMapping("/students/{id}")
	public Student fetchAStudentRecordById(@PathVariable("id")int stdId) throws StudentNotFoundException {
		LOGGER.info("In the side StudentController.fetchAStudentRecordById() method");
		return stdService.fetchAStudentRecordById(stdId);
	}
	
	@GetMapping("/students/name/{name}")
	public Student fetchAStudentRecordByName(@PathVariable("name") String stdName) {
		LOGGER.info("In the side StudentController.fetchAStudentRecordByName() method");
		return stdService.fetchAStudentRecordByName(stdName);
	}
	
	@GetMapping("/students/email/{email}")
	public Student fetchAStudentRecordByEmail(@PathVariable("email") String stdEmail) {
		LOGGER.info("In the side StudentController.fetchAStudentRecordByEmail() method");
		return stdService.fetchAStudentRecordByEmail(stdEmail);
	}
	
	
	@DeleteMapping("/students/{id}")
	public String deleteAStudentRecordById(@PathVariable("id") int stdId) {
		stdService.deleteAStudentRecordById(stdId);
		return "Student deleted successfully";
	}
	
	@PutMapping("/students/{id}")
	public Student updateAStudentRecordById(@PathVariable("id") int stdId, @RequestBody Student student){
		
		return stdService.updateAStudentRecordById(stdId, student);
	}

	
}

