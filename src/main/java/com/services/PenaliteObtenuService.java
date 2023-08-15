package com.services;

import java.util.List;

import com.dto.PenaliteObtenuDto;

public interface PenaliteObtenuService {
	
	List<PenaliteObtenuDto> findAll();
	
	PenaliteObtenuDto findById(Long id );
	
	PenaliteObtenuDto save(PenaliteObtenuDto penaliteObtenuDto);
	
	PenaliteObtenuDto update(Long id, PenaliteObtenuDto penaliteObtenuDto);
	
	void delete (Long id);

}
