package com.services;

import java.util.List;

import com.dto.CommuneDto;

public interface CommuneService {
	
	List<CommuneDto> findAll ();
	
	CommuneDto findById (Long id);
	
	CommuneDto save(CommuneDto communeDto);
	
	CommuneDto update(Long id, CommuneDto communeDto);
	
	void delete(Long id);

}
