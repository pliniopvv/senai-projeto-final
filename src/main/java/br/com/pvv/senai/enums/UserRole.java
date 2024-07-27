package br.com.pvv.senai.enums;

public enum UserRole {
	ADMIN("ADMIN"),
	MEDICO("MEDICO"),
	PACIENTE("PACIENTE");
	
	private String nome;
	UserRole(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return this.nome;
	}
}
