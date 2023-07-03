package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class RegionAdministrativeDto {
	
	private String code;
	
	private String libelle ;

	private String capital;

	private String chef_Lieu_Region ;
@JsonIgnore
    private List<PrefectureDto> prefecture;
}
