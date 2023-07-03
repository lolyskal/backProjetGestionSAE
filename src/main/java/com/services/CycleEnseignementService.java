package com.services;

import java.util.List;

import com.dto.CycleEnseignementDto;

public interface CycleEnseignementService {
	
	List<CycleEnseignementDto> findAll();
	
	CycleEnseignementDto findById(String code);
	
	CycleEnseignementDto save (CycleEnseignementDto cycleEnseignementDto);
	
	CycleEnseignementDto update (String code, CycleEnseignementDto cycleEnseignementDto);
	
	void delete (String code);

}
