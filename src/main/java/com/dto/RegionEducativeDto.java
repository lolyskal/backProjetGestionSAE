package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class RegionEducativeDto {

	private String libelle;
	
	private String zoneCouverture;

	private String chefLieu;
@JsonIgnore	
	private List<InspectionDto>inspection;
}
