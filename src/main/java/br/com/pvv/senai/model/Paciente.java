package br.com.pvv.senai.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Paciente implements IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(length = 64, nullable = false)
	private String nome; // 8-64
	@Column(nullable = false)
	private String genero;
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	@Column(length = 14) // 000.000.000-00
	@NumberFormat(pattern = "###.###.###-##")
	private String CPF;
	@Column(length = 20)
	private String RG;
	@Column(nullable = false)
	private String estadoCivil;
	@Column(nullable = false)
	@NumberFormat(pattern = "(##) # ####-####")
	private String telefone;
	@Column()
	private String email; // regex \w+@\w+
	@Column(nullable = false, length = 64) // 8-64
	private String naturalidade;
	@Column(nullable = false)
	@NumberFormat(pattern = "(##) # ####-####")
	private String cttDeEmergencia;
	@Column()
	private String alergias;
	@Column()
	private String cuidadosEspecificos;
	@Column()
	private String numeroConvenio;
	@Column()
	private Date validadeConvenio;
	@OneToOne()
	private Endereco endereco;
	@OneToOne()
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getCttDeEmergencia() {
		return cttDeEmergencia;
	}

	public void setCttDeEmergencia(String cttDeEmergencia) {
		this.cttDeEmergencia = cttDeEmergencia;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getCuidadosEspecificos() {
		return cuidadosEspecificos;
	}

	public void setCuidadosEspecificos(String cuidadosEspecificos) {
		this.cuidadosEspecificos = cuidadosEspecificos;
	}

	public String getNumeroConvenio() {
		return numeroConvenio;
	}

	public void setNumeroConvenio(String numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}

	public Date getValidadeConvenio() {
		return validadeConvenio;
	}

	public void setValidadeConvenio(Date validadeConvenio) {
		this.validadeConvenio = validadeConvenio;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}