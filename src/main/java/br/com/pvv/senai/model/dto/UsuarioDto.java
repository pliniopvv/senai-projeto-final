package br.com.pvv.senai.model.dto;

import java.util.Date;

import br.com.pvv.senai.enums.UserRole;
import br.com.pvv.senai.model.Usuario;

public class UsuarioDto extends GenericDto<Usuario> {

	private long Id;
	private String nome;
	private String email;
	private Date dataNascimento;
	private String cpf;
	private String password;
	private UserRole perfil;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getPerfil() {
		return perfil;
	}

	public void setPerfil(UserRole perfil) {
		this.perfil = perfil;
	}

	@Override
	protected Class<Usuario> getType() {
		return Usuario.class;
	}

}