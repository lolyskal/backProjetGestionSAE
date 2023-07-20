package com.services;

import java.util.List;

import com.dto.FraisCycleDto;

public interface FraisCycleService {
	
	List<FraisCycleDto> findAll();
	
	FraisCycleDto findById(Long id);
	
	FraisCycleDto save(FraisCycleDto fraisCycleDto);
	
	FraisCycleDto update(Long id , FraisCycleDto fraisCycleDto);
	
	void delete(Long id);

}
