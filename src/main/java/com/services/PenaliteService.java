package com.services;

import java.util.List;

import com.dto.PenaliteDto;

public interface PenaliteService {
	
	List<PenaliteDto> findAll();
	
	PenaliteDto findById(Long id);
	
	PenaliteDto save(PenaliteDto penaliteDto);
	
	PenaliteDto update(Long id , PenaliteDto penaliteDto);
	
	void delete(Long id);
	
	

}
