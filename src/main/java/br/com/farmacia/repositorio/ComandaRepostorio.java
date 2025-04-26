package br.com.farmacia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farmacia.entidade.Comanda;

public interface ComandaRepostorio extends JpaRepository<Comanda, Long>{

	Comanda findByCodComanda(Integer codComanda);
   
}
