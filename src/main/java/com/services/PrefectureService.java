package com.services;

import java.util.List;

import com.dto.PrefectureDto;

public interface PrefectureService {
	
	List<PrefectureDto> findAll();
	
	PrefectureDto findById(String code);
	
	PrefectureDto save(PrefectureDto prefectureDto);
	
	PrefectureDto update(String code , PrefectureDto audienceDto);
	
	void delete(String code);

}
