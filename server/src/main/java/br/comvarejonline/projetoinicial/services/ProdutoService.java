package br.comvarejonline.projetoinicial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.comvarejonline.projetoinicial.controllers.exceptions.DatabaseException;
import br.comvarejonline.projetoinicial.model.Produto;
import br.comvarejonline.projetoinicial.repository.ProdutoRepository;
import br.comvarejonline.projetoinicial.services.exception.ResourceNotFoundException;

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
		Produto produto = objeto.orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
		return produto;
	}

	@Transactional
	public Produto createProduto(Produto produto) {
		try {
			produto = repository.save(produto);
			return produto;
		} catch (DataIntegrityViolationException e) {
			String codigo = produto.getCodigoDeBarras();
			throw new DatabaseException("Já existe um produto com codigo de barras " + codigo);
		}
	}

	@Transactional
	public Produto updateProduto(Long id, Produto produto) {
		try {
			Optional<Produto> objetoBanco = repository.findById(id);
			Produto produtoBanco = objetoBanco
					.orElseThrow(() -> new ResourceNotFoundException("Produto com id " + id + " não encontrado"));

			// Checa se o código enviado já existe em outro produto cadastrado
			if (!produtoBanco.getCodigoDeBarras().equals(produto.getCodigoDeBarras())) {
				Produto produtoExistente = repository.findByCode(produto.getCodigoDeBarras());
				if (produtoExistente != null)
					throw new DataIntegrityViolationException(null);
			}

			produtoBanco.setCodigoDeBarras(produto.getCodigoDeBarras());
			produtoBanco.setNome(produto.getNome());
			produtoBanco.setQuantidadeMinima(produto.getQuantidadeMinima());
			produto = repository.save(produtoBanco);
			return produto;
		} catch (DataIntegrityViolationException e) {
			String codigo = produto.getCodigoDeBarras();
			throw new DatabaseException("Já existe um registro com o código " + codigo);
		}
	}

	@Transactional
	public void deleteProduto(Long id) {
		Optional<Produto> objeto = repository.findById(id);
		if (objeto.isEmpty())
			throw new ResourceNotFoundException("Não há produto cadastrado com id " + id);
		repository.deleteById(id);
	}
}
