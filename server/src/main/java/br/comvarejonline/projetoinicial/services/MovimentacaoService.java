package br.comvarejonline.projetoinicial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.comvarejonline.projetoinicial.model.Movimentacao;
import br.comvarejonline.projetoinicial.repository.MovimentacaoRepository;
import br.comvarejonline.projetoinicial.services.exception.ResourceNotFoundException;

@Service
public class MovimentacaoService {
	@Autowired
	private MovimentacaoRepository repository;

	@Transactional(readOnly = true)
	public List<Movimentacao> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Movimentacao findById(Long id) {
		Optional<Movimentacao> obj = repository.findById(id);
		Movimentacao entity = obj
				.orElseThrow(() -> new ResourceNotFoundException("Movimentação com id " + id + " não encontrada"));
		return entity;
	}
	
	@Transactional
	public Movimentacao create(Movimentacao movimentacao) {
		movimentacao = repository.save(movimentacao);
		return movimentacao;
	}
}
