package br.com.pvv.senai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.pvv.senai.model.Paciente;
import br.com.pvv.senai.repository.PacienteRepository;
import br.com.pvv.senai.security.UsuarioService;

@Service
public class PacienteService extends GenericService<Paciente> {

	@Autowired
	private PacienteRepository repository;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private UsuarioService userService;

	@Override
	public JpaRepository<Paciente, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Paciente create(Paciente model) {
		var endereco = this.enderecoService.create(model.getEndereco());
		var usuario = this.userService.findByEmail(model.getEmail()).get();
		model.setUsuario(usuario);
		var retorno = super.create(model);
		usuario.setPassword(null);
		return retorno;
	}

}
