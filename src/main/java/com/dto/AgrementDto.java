package com.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Data
public class AgrementDto {

	private Long id;

	private String code ;

	private Long numeroAgrement ;

	private  String libelle ;

	private int duree ;


}
