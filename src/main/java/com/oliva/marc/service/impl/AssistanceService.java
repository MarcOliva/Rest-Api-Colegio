package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliva.marc.model.entity.Assistance;
import com.oliva.marc.model.repository.IAssistanceRepository;
import com.oliva.marc.service.IAssistanceService;

@Service
public class AssistanceService implements IAssistanceService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IAssistanceRepository assistanceRepository;

	@Transactional
	@Override
	public Assistance insert(Assistance entity) {
		return assistanceRepository.save(entity);
	}

	@Transactional
	@Override
	public Assistance update(Assistance entity) {
		return assistanceRepository.save(entity);
	}

	@Transactional
	@Override
	public void delete(Assistance entity) {
		assistanceRepository.delete(entity);
		
	}

	@Transactional
	@Override
	public List<Assistance> findAll() {
		return assistanceRepository.findAll();
	}

	@Transactional
	@Override
	public Optional<Assistance> findById(Long id) {
		return assistanceRepository.findById(id);
	}
	
	
}
