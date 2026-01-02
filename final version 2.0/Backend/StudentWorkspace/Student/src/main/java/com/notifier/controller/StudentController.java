package com.notifier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notifier.externalservice.EmailService;
import com.notifier.model.Student;
import com.notifier.service.StudentService;


@RestController
@CrossOrigin("http://localhost:3000")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	EmailService emailService;


	
	//API to get all students details 
	@GetMapping("/getAllStudent")
	public List<Student> getStudents()
	{
		return studentService.getStudents();
	}
	
	
	//API to add students 
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> callGateway()
	{
		return emailService.callGateway();
	}
	
	//method for send email to all student
	@PostMapping("/sendmail")
	public List<ResponseEntity<String>> callEmailService()
	{
		return emailService.callEmailService();
	}
	
	//method for send email by student email
	@PostMapping("/sendmailByEmail")
	public ResponseEntity<String> callEmailServiceByID(@RequestBody String studentEmail)
	{
		return emailService.callEmailServiceByEmail(studentEmail);
	}
	
	
}














