package com.services;

import java.util.List;

import com.dto.CycleEnseignementDto;

public interface CycleEnseignementService {
	
	List<CycleEnseignementDto> findAll();
	
	CycleEnseignementDto findById(Long id);
	
	CycleEnseignementDto save (CycleEnseignementDto cycleEnseignementDto);
	
	CycleEnseignementDto update (Long id, CycleEnseignementDto cycleEnseignementDto);
	
	void delete (Long id);

}
