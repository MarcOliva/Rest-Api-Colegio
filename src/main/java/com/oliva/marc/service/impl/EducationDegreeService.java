package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliva.marc.model.entity.EducationDegree;
import com.oliva.marc.model.repository.IEducationDegreeRepository;
import com.oliva.marc.service.IEducationDegreeService;

@Service
public class EducationDegreeService implements IEducationDegreeService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IEducationDegreeRepository educationDegreeRepository;

	@Transactional
	@Override
	public EducationDegree insert(EducationDegree entity) {
		return educationDegreeRepository.save(entity);
	}
	@Transactional
	@Override
	public EducationDegree update(EducationDegree entity) {
		return educationDegreeRepository.save(entity);
	}
	@Transactional
	@Override
	public void delete(Long id) {
		educationDegreeRepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public List<EducationDegree> findAll() {
		return educationDegreeRepository.findAll();
	}
	@Transactional
	@Override
	public Optional<EducationDegree> findById(Long id) {
		return educationDegreeRepository.findById(id);
	}
	
	
}
