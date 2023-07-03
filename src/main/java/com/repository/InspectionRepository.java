package com.repository;

import com.entities.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<Inspection, Integer> {

}
