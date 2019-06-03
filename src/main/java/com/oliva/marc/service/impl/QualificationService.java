package com.oliva.marc.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.oliva.marc.model.entity.Qualification;
import com.oliva.marc.model.repository.IQualificationRepository;
import com.oliva.marc.service.IQualificationService;

@Service
public class QualificationService implements IQualificationService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IQualificationRepository qualificationRepository;

	@Transactional
	@Override
	public Qualification insert(Qualification entity) {
		return qualificationRepository.save(entity);
	}
	@Transactional
	@Override
	public Qualification update(Qualification entity) {
		return qualificationRepository.save(entity);
	}
	@Transactional
	@Override
	public void delete(Qualification entity) {
		qualificationRepository.delete(entity);
		
	}
	@Transactional
	@Override
	public List<Qualification> findAll() {
		return qualificationRepository.findAll();
	}
	@Transactional
	@Override
	public Optional<Qualification> findById(Long id) {
		return qualificationRepository.findById(id);
	}
	
	
}
