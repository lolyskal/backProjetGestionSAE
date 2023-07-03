package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
public class CommuneDto {

	private String code; ;

	private String libelle ;

	private PrefectureDto prefecture ;
@JsonIgnore
	private List<CantonDto> canton;

}
