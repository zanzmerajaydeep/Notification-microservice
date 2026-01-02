package com.notifier.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notifier.model.Student;
import com.notifier.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;
	
	
	@Override
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}
	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}
	
}
