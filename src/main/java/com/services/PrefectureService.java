package com.services;

import java.util.List;

import com.dto.PrefectureDto;

public interface PrefectureService {
	
	List<PrefectureDto> findAll();
	
	PrefectureDto findById(Long id);
	
	PrefectureDto save(PrefectureDto prefectureDto);
	
	PrefectureDto update(Long id , PrefectureDto audienceDto);
	
	void delete(Long id);

}
