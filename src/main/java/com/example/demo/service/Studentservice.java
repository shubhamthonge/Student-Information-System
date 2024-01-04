package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.dto.Student;

@Service
public class Studentservice {

	@Autowired
	StudentRepository studentRepository;
	
	public Studentservice() {
		System.out.println(" inside Studentservice cons");
	}
	
	public Student create(Student s) {
		System.out.println("inside Studentservice create");
		
		Student s1=studentRepository.save(s);
		return s1;
	}
	
	public Iterable<Student> getall() {
		System.out.println("inside Studentservice getall");
		Iterable<Student> s1=studentRepository.findAll();
		System.out.println(" student list"+s1);
		return s1;
	}
	
	
	public Student getbyid(int id) {
		System.out.println("inside Studentservice getbyid ");
		 Optional<Student> s =studentRepository.findById(id);
		 if(s.isPresent()){
			 System.out.println("id is present"+id);
			 Student s1=s.get();
			 System.out.println(s1);
			 return s1;
		 }else {
			 System.out.println("id is not present"+id);
			 return new Student();
		 }
	}
	
	public Student update(Student st) {
		Student stdupdate= new Student();
		Optional<Student> s=studentRepository.findById(st.getId());
		
		if(s.isPresent()) {
		Student stdb =s.get();	
		System.out.println("Student from db"+stdupdate);
		stdupdate.setId(stdb.getId());
		
		if(st.getName()== null) {
		 System.out.println(" name from UI");
		 stdupdate.setName(stdb.getName());
		}else {
			System.out.println("name from db");
			stdupdate.setName(st.getName());
		}
		if (st.getEmail()==null) {
			System.out.println("email from UI");
			stdupdate.setEmail(stdb.getEmail());
		}else {
			System.out.println("email from db");
			stdupdate.setEmail(st.getEmail());
		}
		System.out.println("final output"+stdupdate);
		Student sd=studentRepository.save(stdupdate);
		return sd;
		}else {
			System.out.println("student is not present"+st.getId());
			return null;
		}
	}
}