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
import com.oliva.marc.model.entity.Empowered;
import com.oliva.marc.service.IEmpoweredService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/apoderados")
@Api(value = "Servicio Web RESTful de apoderados")
public class EmpoweredController {

	@Autowired
	private IEmpoweredService empoweredService;
	
	@ApiOperation("Retorna una lista de apoderados")
	@GetMapping
	public ResponseEntity<List<Empowered>> listar() {
		List<Empowered> empowereds = new ArrayList<>();
		empowereds = empoweredService.findAll();
		return new ResponseEntity<List<Empowered>>(empowereds, HttpStatus.OK);
	}

	@ApiOperation("Retorna una lista de apoderados por id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Empowered> listarId(@PathVariable("id") Long id) {
		Optional<Empowered> empowered = empoweredService.findById(id);
		if (!empowered.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Empowered>(empowered.get(), HttpStatus.OK);
	}

	@ApiOperation("Registra un apoderado")
	@PostMapping
	public ResponseEntity<Empowered> registrar(@RequestBody Empowered empowered){
		Empowered empoweredNew = new Empowered();
		empoweredNew = empoweredService.insert(empowered);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(empoweredNew.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

	@ApiOperation("Modifica un apoderado")
	@PutMapping
	public ResponseEntity<Empowered> actualizar(@RequestBody Empowered empowered) {
		empoweredService.update(empowered);
		return new ResponseEntity<Empowered>(HttpStatus.OK);
	}

	@ApiOperation("Elimina un apoderado")
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Long id) {
		Optional<Empowered> empowered = empoweredService.findById(id);
		if (!empowered.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			empoweredService.delete(id);
		}
	}
}
