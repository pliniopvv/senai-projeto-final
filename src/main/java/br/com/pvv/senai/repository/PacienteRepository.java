package br.com.pvv.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import br.com.pvv.senai.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>, QueryByExampleExecutor<Paciente> {
	Paciente findByEmail(String email);
}
