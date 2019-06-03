package com.oliva.marc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliva.marc.model.entity.Request;

public interface IRequestRepository extends JpaRepository<Request,Long> {

}
