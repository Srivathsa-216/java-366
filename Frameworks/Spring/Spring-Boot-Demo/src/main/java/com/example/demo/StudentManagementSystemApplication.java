package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Student;
import com.example.demo.repository.studentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	
	
	@Autowired
	private studentRepository repo;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		 * Student stud1 = new Student("Adarsh ","srivathsa M S","adarsh@tt.com");
		 * repo.save(stud1);
		 * 
		 * 
		 * Student stud2 = new Student("Anush ","M","anush@tt.com"); repo.save(stud2);
		 * 
		 * 
		 * Student stud3 = new Student("Karthik ","P","karthik@tt.com");
		 * repo.save(stud3);
		 * 
		 * 
		 * Student stud4 = new Student("Krishna ","kanth Hatii","kkh@tt.com");
		 * repo.save(stud4);
		 */
		

		/*
		 * Student stud5 = new Student("Manish ","Choudhry o","Mani@tt.com");
		 * repo.save(stud5);
		 */
	}

}
