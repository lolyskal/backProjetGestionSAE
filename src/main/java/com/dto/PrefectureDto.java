package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PrefectureDto {

	private Long id;

	private String libelle ;
	
	private String chefLieu;

	private RegionAdministrativeDto regionAdministrative;
@JsonIgnore
   	private List<CommuneDto> commune;
   	
}
