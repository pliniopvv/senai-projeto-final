package br.com.pvv.senai.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pvv.senai.exceptions.DtoToEntityException;
import br.com.pvv.senai.model.IEntity;
import br.com.pvv.senai.model.dto.GenericDto;
import br.com.pvv.senai.service.GenericService;

@RestController
public abstract class GenericController<U extends GenericDto<T>, T extends IEntity> {

	public abstract GenericService<T> getService();
		
	@GetMapping("{id}")
	public T get(@PathVariable long id) {
		return getService().get(id);
	}
	
	@PutMapping("{id}")
	public T put(@PathVariable long id, @RequestBody U model) throws DtoToEntityException {
		try {
			return getService().alter(model.getId(), model.makeEntity());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e) {
			e.printStackTrace();
			throw new DtoToEntityException(e.getMessage());
		}
	}
	
	@PostMapping
	public T post(@RequestBody U model) throws DtoToEntityException {
		try {
			return getService().create(model.makeEntity());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e) {
			e.printStackTrace();
			throw new DtoToEntityException(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public boolean delete(@PathVariable long id) {
		return getService().delete(id);
	}
}
