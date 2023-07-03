package com.services;

import com.dto.CantonDto;

import java.util.List;


public interface CantonService {
	
	 List<CantonDto> findAll();

	    CantonDto findById(String code);

	    CantonDto save(CantonDto cantonDto);

	    CantonDto update(String code, CantonDto cantonDto);

	    void delete(String code);

}
