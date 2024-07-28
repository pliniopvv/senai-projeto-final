package br.com.pvv.senai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.pvv.senai.model.Consulta;
import br.com.pvv.senai.repository.ConsultaRepository;

@Service
public class ConsultaService extends GenericService<Consulta> {

	@Autowired
	private ConsultaRepository repository;

	@Autowired
	private PacienteService pacienteService;

	@Override
	public JpaRepository<Consulta, Long> getRepository() {
		return repository;
	}

	@Override
	public Consulta create(Consulta model) {
		var paciente = pacienteService.findByEmail(model.getPaciente().getEmail()); // paciente já cadastrado - operação
																					// DEVE ter sucesso.
		model.setPaciente(paciente);
		return super.create(model);
	}

	@Override
	public Consulta alter(long id, Consulta model) {
		var paciente = pacienteService.findByEmail(model.getPaciente().getEmail()); // paciente já cadastrado - operação
																					// DEVE ter sucesso.
		model.setPaciente(paciente);
		return super.alter(id, model);
	}

}
