package com.services;

import java.util.List;

import com.dto.EtablissementDto;

public interface EtablissementService {
	
	List<EtablissementDto> findAll();
	
	EtablissementDto findById (String nom_Etablissement);
	
	EtablissementDto save(EtablissementDto etablissementDto);
	
	EtablissementDto update(String nom_Etablissement , EtablissementDto etablissementDto);
	
	void delete(String nom_Etablisement);


}
