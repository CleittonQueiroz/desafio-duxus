package br.com.duxusdesafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.duxusdesafio.model.Integrante;

@Repository
public interface IntegranteRepository extends JpaRepository<Integrante, Long> {

}