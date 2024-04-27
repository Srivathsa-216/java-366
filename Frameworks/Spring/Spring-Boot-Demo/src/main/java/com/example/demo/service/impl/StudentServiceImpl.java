package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.studentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private studentRepository repo;
	
	public StudentServiceImpl(studentRepository repo) {
		super();
		this.repo = repo;
	}



	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		return repo.findAll();
	}



	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		
		
		return repo.save(student);
	}



	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		
		return repo.save(student);
		
	}



	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}



	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		
		repo.deleteById(id);
	}

	
	
}
