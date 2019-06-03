package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliva.marc.model.entity.Empowered;
import com.oliva.marc.model.repository.IEmpoweredRepository;
import com.oliva.marc.service.IEmpoweredService;

@Service
public class EmpoweredService implements IEmpoweredService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IEmpoweredRepository empoweredRepository;

	@Transactional
	@Override
	public Empowered insert(Empowered entity) {
		return empoweredRepository.save(entity);
	}
	@Transactional
	@Override
	public Empowered update(Empowered entity) {
		return empoweredRepository.save(entity);
	}
	@Transactional
	@Override
	public void delete(Empowered entity) {
		empoweredRepository.delete(entity);
		
	}
	@Transactional
	@Override
	public List<Empowered> findAll() {
		return empoweredRepository.findAll();
	}
	@Transactional
	@Override
	public Optional<Empowered> findById(Long id) {
		return empoweredRepository.findById(id);
	}
	
}
