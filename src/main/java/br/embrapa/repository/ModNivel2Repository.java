package br.embrapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.embrapa.model.ModNivel2;
import br.embrapa.model.pk.ModNivel2_PK;
import br.embrapa.repository.consultas.ModNivel2RepositoryQuery;

public interface ModNivel2Repository extends JpaRepository<ModNivel2, ModNivel2_PK>, ModNivel2RepositoryQuery {

}
