package com.services;

import java.util.List;

import com.dto.InspectionDto;

public interface InspectionService {
	
	List<InspectionDto> findAll();
	
	InspectionDto findById (Long id);
	
	InspectionDto save(InspectionDto inspectionDto);
	
	InspectionDto update(Long id , InspectionDto inspectionDto);
	
	void delete(Long id);

}
