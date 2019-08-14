package com.br.zup.avaliacao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.zup.avaliacao.models.ReceitaModel;
@Repository
public interface ReceitaRepository extends CrudRepository<ReceitaModel, Integer>{

}
