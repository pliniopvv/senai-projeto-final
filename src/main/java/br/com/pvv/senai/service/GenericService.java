package br.com.pvv.senai.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.pvv.senai.controller.filter.IFilter;
import br.com.pvv.senai.model.IEntity;

@Service
public abstract class GenericService<T extends IEntity> {

	public abstract JpaRepository<T, Long> getRepository();

	public Page<T> all(IFilter<T> filter) {
		var retorno = this.getRepository().findAll(filter.example(), filter.getPagination());
		return retorno;
	}

	public T create(T model) {
		return this.getRepository().save(model);
	}

	public T get(long id) {
		return this.getRepository().findById(id).orElse(null);
	}

	public T alter(long id, T model) {
		model.setId(id);
		return this.getRepository().save(model);
	}

	public boolean delete(long id) {
		Optional<T> model = this.getRepository().findById(id);
		if (model.isPresent())
			this.getRepository().delete(model.get());
		else
			return false;
		return true;
	}

	public boolean delete(T model) {
		if (this.getRepository().existsById(model.getId()))
			this.getRepository().delete(model);
		else
			return false;
		return true;
	}

}
