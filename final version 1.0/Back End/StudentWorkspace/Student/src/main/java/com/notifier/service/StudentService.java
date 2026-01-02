package com.notifier.service;

import java.util.List;

import com.notifier.model.Student;

public interface StudentService {
	
	//to get all students 
	public List<Student> getStudents();
	
	//to add student
	public Student addStudent(Student student);

	
}
