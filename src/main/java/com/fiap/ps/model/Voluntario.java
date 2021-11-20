package com.fiap.ps.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document

public class Voluntario {
	
	@Id
	public String id;
	public String nome;
	public String cpf;
	public String sexo;
	public String dataNascimento;
	public String estadoCivil;
	public String cargo;

}
