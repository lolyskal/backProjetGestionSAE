package com.services;

import java.util.List;

import com.dto.OrdreEnseignementDto;

public interface OrdreEnseignementService {
	
	List<OrdreEnseignementDto> findAll();
	
	OrdreEnseignementDto findById(String code);
	
	OrdreEnseignementDto save(OrdreEnseignementDto OrdreEnseignementDto);
	
	OrdreEnseignementDto update(String code , OrdreEnseignementDto ordreEnseignementDto);
	
	void delete(String code);

}
