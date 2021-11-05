package br.senai.sp.jandira.model;

import java.util.Set;

public class Aluno {
	
	private String Nome;
	private String Matricula;
	private String periodo;
	
	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
  public String getMatricula() {
	return Matricula;
  }
  public String getNome() {
	return Nome;
}
  public void setNome(String nome) {
	Nome = nome;
}
  public String getPeriodo() {
	return periodo;
}
  public void setPeriodo(String periodo) {
	this.periodo = periodo;
}
}
