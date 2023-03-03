package br.comvarejonline.projetoinicial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.comvarejonline.projetoinicial.model.Movimentacao;
import br.comvarejonline.projetoinicial.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	@Autowired
	private MovimentacaoRepository repository;
	
	@Transactional(readOnly = true)
	public List<Movimentacao> findAll() {
		return repository.findAll();
	}
}
