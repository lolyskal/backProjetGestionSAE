package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
public class OrdreEnseignementDto {
	
	 private String code; ;

	private String libelle ;
@JsonIgnore
	private List<EtablissementDto> etablissement ;
	

}
