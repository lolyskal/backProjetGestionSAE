package com.services;

import java.util.List;

import com.dto.InspectionDto;

public interface InspectionService {
	
	List<InspectionDto> findAll();
	
	InspectionDto findById (Integer numero);
	
	InspectionDto save(InspectionDto inspectionDto);
	
	InspectionDto update(Integer numero , InspectionDto inspectionDto);
	
	void delete(Integer numero);

}
