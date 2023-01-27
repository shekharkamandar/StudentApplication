package com.main.sub.service;

import java.util.List;
import java.util.Optional;

import com.main.sub.model.Student;

public interface StudentService {
	//Save data
	public Student saveStudent(Student student);
	
	
	//Get By id
	public Optional<Student> getStudentById(int id);
	
	//Get By All
	public List<Student> getAllStudent();
	
	//Delete by id
	public void deleteStudent(int id);
	
	//Update data
	public Student updateStudent(int id,Student newStudent);

}
