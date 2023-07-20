package com.dto;

import lombok.Data;

@Data
public class SanctionObtenuDto {
	private Long id;
	private int date ;

	private String motif;

	private EtablissementDto etablissement;

	private SanctionDto sanction;

}
