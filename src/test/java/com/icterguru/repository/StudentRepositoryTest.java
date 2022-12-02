
package com.icterguru.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.icterguru.entity.Student;

@SpringBootTest
//@DataJpaTest
public class StudentRepositoryTest {
	/*
	@Autowired
	private IStudentRepository stdRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void saveStudentRecord() {
		Student std = 
				Student.builder()
				.studentName("Mokter Hossain")
				.studentEmail("MokterHossain@gmail.com")
				.studentPhone("123456789")
				.studentNotes("Hi there, This is Mokter Hossain")
				.build();

		stdRepository.save(std);
	}


	@Test
	public void printAllStudentRecord() {
		List<Student> studentList = 
				stdRepository.findAll();
		System.out.println("studentList: " + studentList);

	}
*/
	
	/*
	@BeforeEach
	public void setUp() throws Exception {

		System.out.println("Before each in StudentRepositoryTest.....");
			Student std = 
				Student.builder()
				.studentName("Mokter Hossain")
				.studentEmail("MokterHossain@gmail.com")
				.studentPhone("123456789")
				.studentNotes("Hi there, This is Mokter Hossain")
				.build();



		entityManager.persist(std);

		Mockito.when(stdRepository.findByStudentNameIgnoreCase("CS"))
		.thenReturn(std);


	}
	 */
	/*
	@Test
	public void whenValidFindBiId_thenReturnStudent() {

		assertEquals("Hello World", "Hello World");
		Student foundStudentName = stdRepository.findById(1).get();
		assertEquals(foundStudentName.getStudentName(), "Mokter Hossain");

	}
	 */

}


