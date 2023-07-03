package com.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AgrementObtenuDto {


	
	private Long numero ;
	
	private Instant date ;

	private String nom_Ministre ;

	private String prenom_Ministre ;

	private int num_Tel_Ministre ;

	private int date_Fin_Agrement ;

	private FraisCycleDto fraisCyle ;

	private  AgrementDto agrement ;
	
	private EtablissementDto etablissement ;


}
