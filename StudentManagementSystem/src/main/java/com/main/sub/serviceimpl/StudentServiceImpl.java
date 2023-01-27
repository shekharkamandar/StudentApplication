package com.main.sub.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.sub.model.Student;
import com.main.sub.repository.StudentRepository;
import com.main.sub.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	StudentRepository repo;
	
	@Override
	public Student saveStudent(Student student) {
		return repo.save(student);
		
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return repo.findAll();
	}

	@Override
	public void deleteStudent(int id) {
		
		repo.deleteById(id);
	}

	@Override
	public Student updateStudent(int id, Student newEntity) {
		
		
	Optional<Student> stud=repo.findById(id);
	
	Student availableEntity=null;
	
	if(stud.isPresent()) {
		availableEntity=stud.get();
	}
	if(availableEntity!=null) {
		if(newEntity.getAge()!=0) {
			availableEntity.setAge(newEntity.getAge());
		}
	}
	repo.save(availableEntity);
	return availableEntity;
		
	}


}
