package com.repository;

import com.entities.Agrement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgrementRepository extends JpaRepository<Agrement, Long> {
}