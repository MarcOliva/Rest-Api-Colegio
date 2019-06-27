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
import com.oliva.marc.model.entity.Teacher;
import com.oliva.marc.service.ITeacherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/profesores")
@Api(value = "Servicio Web RESTful de profesores")
public class TeacherController {

	@Autowired
	private ITeacherService teacherService;

	@ApiOperation("Retorna una lista de profesores")
	@GetMapping
	public ResponseEntity<List<Teacher>> listar() {
		List<Teacher> teachers = new ArrayList<>();
		teachers = teacherService.findAll();
		return new ResponseEntity<List<Teacher>>(teachers, HttpStatus.OK);
	}

	@ApiOperation("Retorna una lista de profesores por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Teacher> listarId(@PathVariable("id") Long id) {
		Optional<Teacher> teacher = teacherService.findById(id);
		if (!teacher.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Teacher>(teacher.get(), HttpStatus.OK);
	}

	@ApiOperation("Registra un profesor")
	@PostMapping
	public ResponseEntity<Teacher> registrar(@RequestBody Teacher teacher) {
		Teacher teacherNew = new Teacher();
		teacherNew = teacherService.insert(teacher);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(teacherNew.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@ApiOperation("Modifica un profesor")
	@PutMapping
	public ResponseEntity<Teacher> actualizar(@RequestBody Teacher teacher) {
		teacherService.update(teacher);
		return new ResponseEntity<Teacher>(HttpStatus.OK);
	}

	@ApiOperation("Elimina un profesor")
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Long id) {
		Optional<Teacher> teacher = teacherService.findById(id);
		if (!teacher.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			teacherService.delete(id);
		}
	}
}
