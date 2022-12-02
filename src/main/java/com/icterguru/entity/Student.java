package com.icterguru.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
/*
@Table(schema = "icterguru_dev", name = "student_table",
uniqueConstraints = @UniqueConstraint(
		name = "studentemail_unique",
		columnNames = "student_email")
		)
*/
@Table(schema = "icterguru_dev", name = "student_table"	)
public class Student {

	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName="student_sequence",
			allocationSize= 1)
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence")
	private int studentId;
//	@SuppressWarnings("deprecation")
	@NotBlank(message = "Student name cann't be empty")
	// Validation at 2:55 Minutes
	private String studentName;
	@Column(name = "student_email",
			nullable = false)
	private String studentEmail;
	private String studentPhone;
	private String studentNotes;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentNotes() {
		return studentNotes;
	}
	public void setStudentNotes(String studentNotes) {
		this.studentNotes = studentNotes;
	}
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, @NotBlank(message = "Student name cann't be empty") String studentName,
			String studentEmail, String studentPhone, String studentNotes) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
		this.studentNotes = studentNotes;
	}
	
	
		@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentPhone=" + studentPhone + ", studentNotes=" + studentNotes + ", getStudentId()="
				+ getStudentId() + ", getStudentName()=" + getStudentName() + ", getStudentEmail()=" + getStudentEmail()
				+ ", getStudentPhone()=" + getStudentPhone() + ", getStudentNotes()=" + getStudentNotes()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	// 5:00
	
	
}
