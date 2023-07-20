package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Data
public class FraisCycleDto {

	private Long id;
	private int code ;
	
	private String libelle ;

	private String prix_Cycle_Enseignemant;
@JsonIgnore
	private List<AgrementObtenuDto> agrementObtenu; 
}
