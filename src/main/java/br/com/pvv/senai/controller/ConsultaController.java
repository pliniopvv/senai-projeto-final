package br.com.pvv.senai.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pvv.senai.controller.filter.IFilter;
import br.com.pvv.senai.exceptions.NotImplementedMethodException;
import br.com.pvv.senai.model.Consulta;
import br.com.pvv.senai.model.dto.ConsultaDto;
import br.com.pvv.senai.service.ConsultaService;
import br.com.pvv.senai.service.GenericService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController extends GenericController<ConsultaDto, Consulta> {

	@Autowired
	private ConsultaService service;

	@Override
	public GenericService<Consulta> getService() {
		return service;
	}

	@Override
	public IFilter<Consulta> filterBuilder(Map<String, String> params) throws NotImplementedMethodException {
		throw new NotImplementedMethodException();
	}

}