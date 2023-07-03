package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Etablissement;

public interface EtablissementRepository extends JpaRepository<Etablissement, String> {

}
