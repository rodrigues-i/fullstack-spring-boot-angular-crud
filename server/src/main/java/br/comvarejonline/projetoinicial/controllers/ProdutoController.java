package br.comvarejonline.projetoinicial.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		Produto produto = service.findById(id);
		if (produto == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		return ResponseEntity.ok().body(produto);
	}

	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto produto) {
		produto = service.createProduto(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build().toUri();
		return ResponseEntity.created(uri).body(produto);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Produto> put(@PathVariable Long id, @RequestBody Produto produto) {
		produto = service.updateProduto(id, produto);
		return ResponseEntity.ok().body(produto);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteProduto(id);
		return ResponseEntity.noContent().build();
	}
}
