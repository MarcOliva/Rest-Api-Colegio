package com.oliva.marc.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.oliva.marc.exception.ModeloNotFoundException;
import com.oliva.marc.model.entity.Qualification;
import com.oliva.marc.service.impl.QualificationService;

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
@RequestMapping("/notas")
public class QualificationController{

    
	@Autowired
	private QualificationService qualificationService;

	@GetMapping
	public ResponseEntity<List<Qualification>> listar() {
		List<Qualification> qualifications = new ArrayList<>();
		qualifications = qualificationService.findAll();
		return new ResponseEntity<List<Qualification>>(qualifications, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Qualification> listarId(@PathVariable("id") Long id) {
		Optional<Qualification> qualification = qualificationService.findById(id);
		if (!qualification.isPresent()) {
			throw new ModeloNotFoundException("ID: " + id);
		}

		return new ResponseEntity<Qualification>(qualification.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Qualification> registrar(@RequestBody Qualification qualification){
		Qualification qualificationNew = new Qualification();
		qualificationNew = qualificationService.insert(qualification);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(qualificationNew.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Qualification> actualizar(@RequestBody Qualification qualification) {
		qualificationService.update(qualification);
		return new ResponseEntity<Qualification>(HttpStatus.OK);
	}

	
}