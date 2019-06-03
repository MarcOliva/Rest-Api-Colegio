package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliva.marc.model.entity.Course;
import com.oliva.marc.model.repository.ICourseRepository;
import com.oliva.marc.service.ICourseService;

@Service
public class CourseService implements ICourseService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ICourseRepository courseRepository;

	@Transactional
	@Override
	public Course insert(Course entity) {
		return courseRepository.save(entity);
	}
	@Transactional
	@Override
	public Course update(Course entity) {
		return courseRepository.save(entity);
	}
	@Transactional
	@Override
	public void delete(Course entity) {
		courseRepository.delete(entity);
		
	}
	@Transactional
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	@Transactional
	@Override
	public Optional<Course> findById(Long id) {
		return courseRepository.findById(id);
	}
	
}
