package com.services;

import java.util.List;

import com.dto.RegionEducativeDto;

public interface RegionEducativeService {
	
	List<RegionEducativeDto> findAll();
	
	RegionEducativeDto findById(String libelle);
	
	RegionEducativeDto save(RegionEducativeDto regionEducativeDto);
	
	RegionEducativeDto update(String libelle, RegionEducativeDto regionEducativeDto);
	
	void delete(String libelle);
	

}
