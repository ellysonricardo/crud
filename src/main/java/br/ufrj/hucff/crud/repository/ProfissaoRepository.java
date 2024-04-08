package br.ufrj.hucff.crud.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.ufrj.hucff.crud.modelo.Profissao;

public interface ProfissaoRepository extends CrudRepository<Profissao, UUID> {

}
