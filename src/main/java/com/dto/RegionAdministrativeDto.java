package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class RegionAdministrativeDto {
	private Long id;
	private String code;
	
	private String libelle ;

	private String capital;

	private String chefLieuRegion ;
@JsonIgnore
    private List<PrefectureDto> prefecture;
}
