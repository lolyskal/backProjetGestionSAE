package com.services;

import java.util.List;

import com.dto.SanctionDto;

public interface SanctionService {
	
	List<SanctionDto> findAll();
	
	SanctionDto findById(Long id);
	
	SanctionDto save(SanctionDto sanctionDto);
	
	SanctionDto update(Long id, SanctionDto sanctionDto);
	
	void delete(Long id);

}
