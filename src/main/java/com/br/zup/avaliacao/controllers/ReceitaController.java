package com.br.zup.avaliacao.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.zup.avaliacao.models.ReceitaModel;
import com.br.zup.avaliacao.services.ReceitaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/zup/receitas")
public class ReceitaController {
	@Autowired
	private ReceitaService receitaService;
	
	@GetMapping("/todas/receitas")
	public ResponseEntity<?> exibiTodasReceitas() {
		return ResponseEntity.ok().body(receitaService.exibirTodasReceitas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> exibirReceitaPeloId(@PathVariable int id) {
		try {
			ReceitaModel receita = receitaService.exibirReceitaPeloId(id);
			return ResponseEntity.ok(receita);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping("/nova/receita")
	public ResponseEntity<?> criarReceita(@Valid @RequestBody ReceitaModel receita) {
		try {
			receitaService.criarReceita(receita);
			return ResponseEntity.status(HttpStatus.CREATED).body(receita);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/atualizar/receita/{id}")
	public ResponseEntity<?> atualizarReceita(@PathVariable int id,@RequestBody ReceitaModel novaReceita) {
		try {
			return ResponseEntity.ok().body(receitaService.atualizarReceita(id, novaReceita));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirReceita(@PathVariable int id) {
		receitaService.excluirReceita(id);
		return ResponseEntity.ok().build();
	}
	
 }







