package br.comvarejonline.projetoinicial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.comvarejonline.projetoinicial.model.Produto;
import br.comvarejonline.projetoinicial.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> get() {
		List<Produto> produtos = service.findAll();
		return ResponseEntity.ok().body(produtos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> get(@PathVariable Long id) {
		Produto produto = service.findbyId(id);
		if (produto == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.ok().body(produto);
	}
}
