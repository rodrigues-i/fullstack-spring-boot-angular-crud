package br.comvarejonline.projetoinicial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.comvarejonline.projetoinicial.model.Produto;
import br.comvarejonline.projetoinicial.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;

	@Transactional(readOnly = true)
	public List<Produto> findAll() {
		List<Produto> produtos = repository.findAll();
		return produtos;
	}

	@Transactional(readOnly = true)
	public Produto findById(Long id) {
		Optional<Produto> objeto = repository.findById(id);
		if (objeto.isEmpty())
			return null;
		return objeto.get();
	}

	@Transactional
	public Produto createProduto(Produto produto) {
		produto = repository.save(produto);
		return produto;
	}
}
