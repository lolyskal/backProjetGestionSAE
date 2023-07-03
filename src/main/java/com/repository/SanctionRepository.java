package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Sanction;

public interface SanctionRepository extends JpaRepository<Sanction, String> {

}
