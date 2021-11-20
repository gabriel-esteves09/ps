package com.fiap.ps.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document

public class Indicador {

	@Id
	public String id;
	public String tipo;
	public String valor;
	
}
