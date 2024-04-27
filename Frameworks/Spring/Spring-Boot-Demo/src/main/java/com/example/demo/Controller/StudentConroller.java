package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentConroller {

	private StudentService service;

	public StudentConroller(StudentService service) {
		super();
		this.service = service;
	}
	
	// handler method to handle list students and return mode and view
	
	
	@RequestMapping("/")
	private String intro() {
		
		return "index";
		
	}
	
	@GetMapping("/students")
	private String listStudents(Model model) {
		
		model.addAttribute("students", service.getAllStudents());
		
		return "students";
		
	}
	
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		//Create student object to hold student form data
		Student student =new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		service.saveStudent(student);
		
		return "redirect:/students";
		
		
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		
		model.addAttribute("student", service.getStudentById(id));
		
		return "edit_student";
		
	}
	
	
	@PostMapping("/students/{id}")
	public String UpdateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model
			) {
		
		//get student from database by id
		
		Student excisting_student =service.getStudentById(id);
		excisting_student.setFirstName(student.getFirstName());
		excisting_student.setLastName(student.getLastName());
		excisting_student.setEmail(student.getEmail());
		
		//save updated student object
		
		service.updateStudent(excisting_student);
		
		return "redirect:/students";
		
		
	}
	
	
	//handler method to handle delete student request
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		
		service.deleteStudentById(id);
		
		return "redirect:/students";
		
		
		
	}
	
	
}
