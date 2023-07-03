package com.services;

import java.util.List;

import com.dto.SanctionObtenuDto;

public interface SanctionObtenuService {
	
	List<SanctionObtenuDto> findAll();
	
	SanctionObtenuDto findById(String date);
	
	SanctionObtenuDto save(SanctionObtenuDto sanctionObtenuDto);
	
	SanctionObtenuDto update(String date,SanctionObtenuDto sanctionObtenuDto);
	
	void delete(String date);

}
