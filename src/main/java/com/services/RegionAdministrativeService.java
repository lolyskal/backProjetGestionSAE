package com.services;

import java.util.List;

import com.dto.RegionAdministrativeDto;

public interface RegionAdministrativeService {
	
	List<RegionAdministrativeDto> findAll();
	
	RegionAdministrativeDto findById(String code);
	
	RegionAdministrativeDto save(RegionAdministrativeDto regionAdministrativeDto);
	
	RegionAdministrativeDto update(String code, RegionAdministrativeDto regionAdministrativeDto);
	
	void delete(String code);

}
