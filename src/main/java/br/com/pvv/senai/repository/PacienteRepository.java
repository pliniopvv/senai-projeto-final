package br.com.pvv.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pvv.senai.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
