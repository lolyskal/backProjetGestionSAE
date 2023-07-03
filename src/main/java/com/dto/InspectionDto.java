package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Data
public class InspectionDto {
	
	private int numero;

	private String libelle;

	private RegionEducativeDto regionEducative;
@JsonIgnore
	private List<EtablissementDto> etablissement ;

}
