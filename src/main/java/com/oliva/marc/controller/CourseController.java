package com.oliva.marc.controller;

import java.net.URI;
import java.util.ArrayList;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oliva.marc.exception.ModeloNotFoundException;
import com.oliva.marc.model.entity.Course;
import com.oliva.marc.service.ICourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cursos")
@Api(value = "Servicio Web RESTful de cursos")
public class CourseController {

	@Autowired
	private ICourseService courseService;

	@ApiOperation("Retorna una lista de cursos")
	@GetMapping
	public ResponseEntity<List<Course>> listar() {
		List<Course> courses = new ArrayList<>();
		courses = courseService.findAll();
		return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
	}

	@ApiOperation("Retorna una lista de cursos por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Course> listarId(@PathVariable("id") Long id) {
		Optional<Course> course = courseService.findById(id);
		if (!course.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Course>(course.get(), HttpStatus.OK);
	}

	@ApiOperation("Registra un curso")
	@PostMapping
	public ResponseEntity<Course> registrar(@RequestBody Course course) {
		Course courseNew = new Course();
		courseNew = courseService.insert(course);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(courseNew.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@ApiOperation("Modifica un curso")
	@PutMapping
	public ResponseEntity<Course> actualizar(@RequestBody Course course) {
		courseService.update(course);
		return new ResponseEntity<Course>(HttpStatus.OK);
	}

	@ApiOperation("Elimina un curso")
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Long id) {
		Optional<Course> course = courseService.findById(id);
		if (!course.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			courseService.delete(id);
		}
	}
}
