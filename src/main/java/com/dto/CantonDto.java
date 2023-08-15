package com.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
public class CantonDto {

	private Long id;
	
	private String code;
	
	private String libelle;

	private CommuneDto commune ;
@JsonIgnore
	private List<EtablissementDto> etablissement ;
}