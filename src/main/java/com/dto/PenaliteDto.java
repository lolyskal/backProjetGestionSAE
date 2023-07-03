package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PenaliteDto {
	
	 private String typePenalite;

	private Integer duree ;

	private int montants;
@JsonIgnore
	private List<PenaliteObtenuDto> penalite_Obtenu;
}
