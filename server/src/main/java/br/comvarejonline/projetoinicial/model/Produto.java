package br.comvarejonline.projetoinicial.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String codigoDeBarras;
	private String nome;
	private Long quantidadeMinima;
	private Double saldoInicial;

	public Produto() {
	}

	public Produto(Long id, String codigoDeBarras, String nome, Long quantidadeMinima, Double saldoInicial) {
		super();
		this.id = id;
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.quantidadeMinima = quantidadeMinima;
		this.saldoInicial = saldoInicial;
	}
}
