package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliva.marc.model.entity.Day;
import com.oliva.marc.model.repository.IDayRepository;
import com.oliva.marc.service.IDayService;

@Service
public class DayService implements IDayService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IDayRepository dayRepository;

	@Transactional
	@Override
	public Day insert(Day entity) {
		return dayRepository.save(entity);
	}
	@Transactional
	@Override
	public Day update(Day entity) {
		return dayRepository.save(entity);
	}
	@Transactional
	@Override
	public void delete(Day entity) {
		dayRepository.delete(entity);
		
	}
	@Transactional
	@Override
	public List<Day> findAll() {
		return dayRepository.findAll();
	}
	@Transactional
	@Override
	public Optional<Day> findById(Long id) {
		return dayRepository.findById(id);
	}
	
}
