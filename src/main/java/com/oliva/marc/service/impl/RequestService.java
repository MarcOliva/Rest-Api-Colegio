package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliva.marc.model.entity.Request;
import com.oliva.marc.model.repository.IRequestRepository;
import com.oliva.marc.service.IRequestService;

@Service
public class RequestService implements IRequestService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IRequestRepository requestRepository;

	@Transactional
	@Override
	public Request insert(Request entity) {
		return requestRepository.save(entity);
	}
	@Transactional
	@Override
	public Request update(Request entity) {
		return requestRepository.save(entity);
	}
	@Transactional
	@Override
	public void delete(Long id) {
		requestRepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public List<Request> findAll() {
		return requestRepository.findAll();
	}
	@Transactional
	@Override
	public Optional<Request> findById(Long id) {
		return requestRepository.findById(id);
	}
	
}
