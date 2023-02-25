package br.comvarejonline.projetoinicial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.comvarejonline.projetoinicial.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	@Query("SELECT p FROM Produto p WHERE p.codigoDeBarras = (:codigo)")
	public Produto findByCode(@Param("codigo") String codigoDeBarras);

}