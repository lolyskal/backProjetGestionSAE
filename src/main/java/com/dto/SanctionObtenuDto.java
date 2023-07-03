package com.dto;

import lombok.Data;

@Data
public class SanctionObtenuDto {
	
	private int date ;

	private String motif;

	private EtablissementDto etablissement;

	private SanctionDto sanction;

}
