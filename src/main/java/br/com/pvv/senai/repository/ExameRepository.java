package br.com.pvv.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.pvv.senai.model.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long>, QueryByExampleExecutor<Exame> {

}
