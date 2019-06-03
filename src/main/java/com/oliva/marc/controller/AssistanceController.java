package com.oliva.marc.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.oliva.marc.exception.ModeloNotFoundException;
import com.oliva.marc.model.entity.Assistance;
import com.oliva.marc.service.impl.AssistanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/asistencias")
public class AssistanceController{

    
	@Autowired
	private AssistanceService assistanceService;

	@GetMapping
	public ResponseEntity<List<Assistance>> listar() {
		List<Assistance> assistances = new ArrayList<>();
		assistances = assistanceService.findAll();
		return new ResponseEntity<List<Assistance>>(assistances, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Assistance> listarId(@PathVariable("id") Long id) {
		Optional<Assistance> assistance = assistanceService.findById(id);
		if (!assistance.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}

		return new ResponseEntity<Assistance>(assistance.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Assistance> registrar(@RequestBody Assistance assistance){
		Assistance assistanceNew = new Assistance();
		assistanceNew = assistanceService.insert(assistance);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(assistanceNew.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Assistance> actualizar(@RequestBody Assistance assistance) {
		assistanceService.update(assistance);
		return new ResponseEntity<Assistance>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable Long id) {
		Optional<Assistance> assistance = assistanceService.findById(id);
		if (!assistance.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			assistanceService.delete(id);
		}
	}
}