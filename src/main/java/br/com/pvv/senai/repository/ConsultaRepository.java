package br.com.pvv.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pvv.senai.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

}
