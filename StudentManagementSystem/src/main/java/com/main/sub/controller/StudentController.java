package com.main.sub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.sub.model.Student;
import com.main.sub.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studservice;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student studentRequest){
		
		
		Student savedstudent=studservice.saveStudent(studentRequest);
		
		return ResponseEntity.ok().body(savedstudent);
		
	}
	@GetMapping("/get/{sid}")
	public ResponseEntity<Student> getStudentById(@PathVariable("sid")int id){
		
		
		Optional<Student> stud= studservice.getStudentById(id);
		
		if(stud.isPresent()) {
			return new ResponseEntity<>(stud.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudent(){
		
		List<Student> listStud=studservice.getAllStudent();
		
		return new ResponseEntity<>(listStud,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{sid}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("sid")int id){
	
		Optional<Student> stud= studservice.getStudentById(id);
		
		if(stud.isPresent()) {
			
			studservice.deleteStudent(id);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@PutMapping("update/{id}")
	public Student updateStudent(@PathVariable("id")int id,@RequestBody Student newEntity) {
		
		return studservice.updateStudent(id, newEntity);
	}
}
