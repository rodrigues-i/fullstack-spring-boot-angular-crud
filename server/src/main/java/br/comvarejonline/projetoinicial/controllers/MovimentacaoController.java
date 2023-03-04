package br.comvarejonline.projetoinicial.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.comvarejonline.projetoinicial.model.Movimentacao;
import br.comvarejonline.projetoinicial.services.MovimentacaoService;

@RestController
@RequestMapping(value = "/movimentacoes")
public class MovimentacaoController {
	@Autowired
	private MovimentacaoService service;

	@GetMapping
	public ResponseEntity<List<Movimentacao>> get() {
		List<Movimentacao> movimentacoes = service.findAll();
		return ResponseEntity.ok().body(movimentacoes);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Movimentacao> get(@PathVariable Long id) {
		Movimentacao movimentacao = service.findById(id);
		return ResponseEntity.ok().body(movimentacao);
	}

	@PostMapping
	public ResponseEntity<Movimentacao> post(@RequestBody Movimentacao movimentacao) {
		movimentacao = service.create(movimentacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build().toUri();
		return ResponseEntity.created(uri).body(movimentacao);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<Movimentacao> put(@PathVariable Long id, @RequestBody Movimentacao movimentacao) {
		movimentacao = service.update(id, movimentacao);
		return ResponseEntity.ok().body(movimentacao);
	}
}
