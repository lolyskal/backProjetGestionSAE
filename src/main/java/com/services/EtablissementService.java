package com.services;

import java.util.List;

import com.dto.EtablissementDto;

public interface EtablissementService {
	
	List<EtablissementDto> findAll();
	
	EtablissementDto findById (Long id);
	
	EtablissementDto save(EtablissementDto etablissementDto);
	
	EtablissementDto update(Long id , EtablissementDto etablissementDto);
	
	void delete(Long id);


}
