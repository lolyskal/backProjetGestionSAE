package com.services;

import java.util.List;

import com.dto.PenaliteDto;

public interface PenaliteService {
	
	List<PenaliteDto> findAll();
	
	PenaliteDto findById(String typePenalite);
	
	PenaliteDto save(PenaliteDto penaliteDto);
	
	PenaliteDto update(String typePenalite , PenaliteDto penaliteDto);
	
	void delete(String typePenalite);
	
	

}
