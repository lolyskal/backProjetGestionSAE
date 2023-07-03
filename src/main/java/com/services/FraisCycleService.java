package com.services;

import java.util.List;

import com.dto.FraisCycleDto;

public interface FraisCycleService {
	
	List<FraisCycleDto> findAll();
	
	FraisCycleDto findById(Integer code);
	
	FraisCycleDto save(FraisCycleDto fraisCycleDto);
	
	FraisCycleDto update(Integer code , FraisCycleDto fraisCycleDto);
	
	void delete(Integer code);

}
