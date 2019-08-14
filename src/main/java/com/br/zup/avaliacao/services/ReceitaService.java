package com.br.zup.avaliacao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.avaliacao.models.ReceitaModel;
import com.br.zup.avaliacao.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	@Autowired
	ReceitaRepository receitaRepository;
	
	public long quantidadeReceita() {
		return receitaRepository.count();
	}
	
	public Iterable<ReceitaModel> exibirTodasReceitas() {
		return receitaRepository.findAll();
	}
	
	public ReceitaModel exibirReceitaPeloId(int id) {
		return receitaRepository.findById(id).get();
	}
	
	public void criarReceita(ReceitaModel novaReceita) {
		receitaRepository.save(novaReceita);
	}
	
	public void excluirReceita(int id) {
		receitaRepository.deleteById(id);
	}
	public ReceitaModel atualizarReceita(int id, ReceitaModel atualizar) {
		ReceitaModel receita = new ReceitaModel();
		receita = receitaRepository.findById(id).get();

		if (receita!= null) {
			atualizar.setId(id);
			return receitaRepository.save(atualizar);

		}
		return null;
}
}
