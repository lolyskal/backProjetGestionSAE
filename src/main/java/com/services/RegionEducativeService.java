package com.services;

import java.util.List;

import com.dto.RegionEducativeDto;

public interface RegionEducativeService {
	
	List<RegionEducativeDto> findAll();
	
	RegionEducativeDto findById(Long id);
	
	RegionEducativeDto save(RegionEducativeDto regionEducativeDto);
	
	RegionEducativeDto update(Long id, RegionEducativeDto regionEducativeDto);
	
	void delete(Long id);
	

}
