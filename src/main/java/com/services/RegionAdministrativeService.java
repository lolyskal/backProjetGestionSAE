package com.services;

import java.util.List;

import com.dto.RegionAdministrativeDto;

public interface RegionAdministrativeService {
	
	List<RegionAdministrativeDto> findAll();
	
	RegionAdministrativeDto findById(Long id);
	
	RegionAdministrativeDto save(RegionAdministrativeDto regionAdministrativeDto);
	
	RegionAdministrativeDto update(Long id, RegionAdministrativeDto regionAdministrativeDto);
	
	void delete(Long id);

}
