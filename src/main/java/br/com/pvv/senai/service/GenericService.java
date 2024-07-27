package br.com.pvv.senai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.pvv.senai.model.IEntity;

@Service
public class GenericService<T extends IEntity> {

	@Autowired
	protected JpaRepository<T, Long> repository;
	 
	public T create(T model) {
		return repository.save(model);
	}
	
	public T get(long id) {
		return repository.findById(id).orElse(null);
	}
	
	public T alter(long id, T model) {
		model.setId(id);
		return repository.save(model);
	}
	
	public boolean delete(long id) {
		Optional<T> model = repository.findById(id);
		if (model.isPresent()) repository.delete(model.get());
		else return false;
		return true;
	}
	
	public boolean delete(T model) {
		if (repository.existsById(model.getId())) repository.delete(model);
		else return false;
		return true;
	}
	
}
