package com.services;

import java.util.List;

import com.dto.PenaliteObtenuDto;

public interface PenaliteObtenuService {
	
	List<PenaliteObtenuDto> findAll();
	
	PenaliteObtenuDto findById(String date );
	
	PenaliteObtenuDto save(PenaliteObtenuDto penaliteObtenuDto);
	
	PenaliteObtenuDto update(String date, PenaliteObtenuDto penaliteObtenuDto);
	
	void delete (String date);

}
