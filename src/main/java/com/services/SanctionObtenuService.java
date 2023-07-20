package com.services;

import java.util.List;

import com.dto.SanctionObtenuDto;

public interface SanctionObtenuService {
	
	List<SanctionObtenuDto> findAll();
	
	SanctionObtenuDto findById(Long id);
	
	SanctionObtenuDto save(SanctionObtenuDto sanctionObtenuDto);
	
	SanctionObtenuDto update(Long id,SanctionObtenuDto sanctionObtenuDto);
	
	void delete(Long id);

}
