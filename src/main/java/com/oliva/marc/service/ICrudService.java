package com.oliva.marc.service;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T> {
	
	T insert(T entity);

	T update(T entity);

	void delete(Long id);

	List<T> findAll();

	Optional<T> findById(Long id);
}
