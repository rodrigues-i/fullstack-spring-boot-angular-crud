package br.comvarejonline.projetoinicial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.comvarejonline.projetoinicial.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
