package com.icterguru.entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.icterguru.error.StudentNotFoundException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor

public class ErrorMessage {
	
	private HttpStatus status;
	private String message;
	

	public ErrorMessage(HttpStatus notFound, String message2) {
		// TODO Auto-generated constructor stub
		this.status = notFound;
		this.message = message2;
	}
	

	

}
