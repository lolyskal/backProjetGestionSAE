package com.services;

import java.util.List;

import com.dto.SanctionDto;

public interface SanctionService {
	
	List<SanctionDto> findAll();
	
	SanctionDto findById(String code);
	
	SanctionDto save(SanctionDto sanctionDto);
	
	SanctionDto update(String code, SanctionDto sanctionDto);
	
	void delete(String code);

}
