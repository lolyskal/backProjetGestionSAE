package com.services;

import java.util.List;

import com.dto.OrdreEnseignementDto;

public interface OrdreEnseignementService {
	
	List<OrdreEnseignementDto> findAll();
	
	OrdreEnseignementDto findById(Long id);
	
	OrdreEnseignementDto save(OrdreEnseignementDto OrdreEnseignementDto);
	
	OrdreEnseignementDto update(Long id , OrdreEnseignementDto ordreEnseignementDto);
	
	void delete(Long id);

}
