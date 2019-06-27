package com.oliva.marc.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.oliva.marc.exception.ModeloNotFoundException;
import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.service.impl.EducationDegreeService;

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
@RequestMapping("/grados")
public class EducationDegreeController {

    @Autowired
    private EducationDegreeService educationDegreeService;

    @GetMapping
    public ResponseEntity<List<EducationDegree>> listar() {
        List<EducationDegree> EducationDegrees = new ArrayList<>();
        EducationDegrees = educationDegreeService.findAll();
        return new ResponseEntity<List<EducationDegree>>(EducationDegrees, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EducationDegree> listarId(@PathVariable("id") Long id) {
        Optional<EducationDegree> EducationDegrees = educationDegreeService.findById(id);
        if (!EducationDegrees.isPresent()) {
            throw new ModeloNotFoundException("ID: " + id);
        }

        return new ResponseEntity<EducationDegree>(EducationDegrees.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EducationDegree> registrar(@RequestBody EducationDegree EducationDegree) {
        EducationDegree EducationDegreeNew = new EducationDegree();
        EducationDegreeNew = educationDegreeService.insert(EducationDegree);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(EducationDegreeNew.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<EducationDegree> actualizar(@RequestBody EducationDegree EducationDegree) {
        educationDegreeService.update(EducationDegree);
        return new ResponseEntity<EducationDegree>(HttpStatus.OK);
    }

}