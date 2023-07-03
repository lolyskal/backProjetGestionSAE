package com.services;

import java.util.List;

import com.dto.CommuneDto;

public interface CommuneService {
	
	List<CommuneDto> findAll ();
	
	CommuneDto findById (String code);
	
	CommuneDto save(CommuneDto communeDto);
	
	CommuneDto update(String code, CommuneDto communeDto);
	
	void delete(String code);

}
