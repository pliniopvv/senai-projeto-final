package br.com.pvv.senai.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pvv.senai.controller.filter.IFilter;
import br.com.pvv.senai.controller.filter.PacienteFilter;
import br.com.pvv.senai.exceptions.PacienteUserNotFoundException;
import br.com.pvv.senai.model.Paciente;
import br.com.pvv.senai.model.dto.PacienteDto;
import br.com.pvv.senai.security.UsuarioService;
import br.com.pvv.senai.service.GenericService;

@Controller
@RestController
@RequestMapping("/pacientes")
public class PacienteController extends GenericController<PacienteDto, Paciente> {

	@Autowired
	private GenericService<Paciente> service;

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public GenericService<Paciente> getService() {
		return service;
	}
	
//	@GetMapping
//	public List<Paciente> list(@RequestParam PacienteFilter filter) {
//		return super.list(filter);
//	}

	@Override
	public ResponseEntity post(PacienteDto model) throws Exception {
		if (!usuarioService.has(model.getEmail()))
			throw new PacienteUserNotFoundException(model.getEmail());
		return super.post(model);
	}

	@Override
	public IFilter<Paciente> filterBuilder(Map<String, String> params) {
		return new PacienteFilter(params);
	}

}
