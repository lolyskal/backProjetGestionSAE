package com.services;

import java.util.List;

import com.dto.AgrementObtenuDto;



public interface AgrementObtenuService {

	
	 List<AgrementObtenuDto> findAll();


    AgrementObtenuDto findById(Long id);


    AgrementObtenuDto save(AgrementObtenuDto agrementObtenuDto);

	AgrementObtenuDto update(Long id, AgrementObtenuDto agrementObtenuDto);

	void delete(Long id);
}
