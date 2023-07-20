package com.services;

import com.dto.CantonDto;

import java.util.List;


public interface CantonService {
	
	 List<CantonDto> findAll();

	    CantonDto findById(Long id);

	    CantonDto save(CantonDto cantonDto);

	    CantonDto update(Long id, CantonDto cantonDto);

	    void delete(Long id);

}
