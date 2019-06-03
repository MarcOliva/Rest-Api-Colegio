package com.oliva.marc.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.oliva.marc.exception.ModeloNotFoundException;
import com.oliva.marc.model.entity.Student;
import com.oliva.marc.service.impl.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/alumnos")
public class StudentController{

    
	@Autowired
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> listar() {
		List<Student> students = new ArrayList<>();
		students = studentService.findAll();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Student> listarId(@PathVariable("id") Long id) {
		Optional<Student> students = studentService.findById(id);
		if (!students.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}

		return new ResponseEntity<Student>(students.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Student> registrar(@RequestBody Student student){
		Student studentNew = new Student();
		studentNew = studentService.insert(student);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(studentNew.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Student> actualizar(@RequestBody Student student) {
		studentService.update(student);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

	
}