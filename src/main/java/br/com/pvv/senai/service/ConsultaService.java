package br.com.pvv.senai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.pvv.senai.model.Consulta;
import br.com.pvv.senai.repository.ConsultaRepository;

@Service
public class ConsultaService extends GenericService<Consulta>{

	@Autowired
	private ConsultaRepository repository;
	
	@Override
	public JpaRepository<Consulta, Long> getRepository() {
		return repository;
	}

}
