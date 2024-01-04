package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Student;
import com.example.demo.service.Studentservice;

@RestController
public class Studentcontroller {

	@Autowired
	Studentservice studentservice;
	
	public Studentcontroller() {
		System.out.println("inside Studentcontroller cons");
	}
	
	@PostMapping("/create")
	public Student create(@RequestBody Student s) {
		System.out.println("inside Studentcontroller create");
		Student s1 =studentservice.create(s);
		return s1;
	}
	
	@GetMapping("/getall")
	public Iterable<Student> getall(@RequestBody Student s) {
		System.out.println("inside Studentcontroller getall");
		Iterable<Student> s1 =studentservice.getall();
		return s1;
	}
	
	@GetMapping("/getbyid/{sid}")
	public Student getbyid(@PathVariable ("sid") int id){
		System.out.println("inside Studentcontroller getbyid");
		 Student s=studentservice.getbyid(id);
		 return s;
	}
	
	@PutMapping("/update")
	public Student update(@RequestBody Student s) {
		System.out.println(" inside Studentcontroller ");
		Student std = studentservice.update(s);
		return std;
	}
	
}
