package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Long> {

}
