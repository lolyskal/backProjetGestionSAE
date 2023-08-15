package com.dto;

import lombok.Data;

@Data
public class CycleEnseignementDto {

	private Long id;

	private String code;;

	private String libelle ;


	private EtablissementDto etablissement;

}
