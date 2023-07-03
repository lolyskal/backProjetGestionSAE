package com.services;

import java.util.List;

import com.dto.AgrementObtenuDto;



public interface AgrementObtenuService {

	
	 List<AgrementObtenuDto> findAll();


    AgrementObtenuDto findById(Long numero);

    AgrementObtenuDto save(AgrementObtenuDto agrementObtenuDto);

	AgrementObtenuDto update(Long numero, AgrementObtenuDto agrementObtenuDto);

	void delete(Long numero);
}
