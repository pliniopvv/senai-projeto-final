package br.com.pvv.senai.security;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.pvv.senai.model.Usuario;
import br.com.pvv.senai.service.GenericService;

@Service
public class UsuarioService extends GenericService<Usuario> {
	public boolean has(String email) {
		ExampleMatcher matcher = ExampleMatcher.matchingAny()
				.withIgnoreNullValues();
		Usuario u = new Usuario();
		u.setEmail(email);
		Example example = Example.of(u, matcher);
		return this.repository.exists(example);
	}
}
