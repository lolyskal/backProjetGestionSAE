package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class PenaliteDto {
	 private Integer id;
	 private String typePenalite;

	private Integer duree;

	private Double montant;
@JsonIgnore
	private List<PenaliteObtenuDto> penalite_Obtenu;
}
