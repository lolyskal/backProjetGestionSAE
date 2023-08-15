package com.dto;

import lombok.Data;

@Data
public class PenaliteObtenuDto {

	private Long id;
	private String date ;
	
	private String motif ;
	
	private EtablissementDto etablissement ;

}
