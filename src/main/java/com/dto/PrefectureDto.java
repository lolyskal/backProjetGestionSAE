package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PrefectureDto {

	
	private String code;
	
	private String libelle ;
	
	private String chef_Lieu;

	private RegionAdministrativeDto regionAdministrative;
@JsonIgnore
   	private List<CommuneDto> commune;
   	
}
