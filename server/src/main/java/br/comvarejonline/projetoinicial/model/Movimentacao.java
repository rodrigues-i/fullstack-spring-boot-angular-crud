package br.comvarejonline.projetoinicial.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.comvarejonline.projetoinicial.utils.TipoMovimentacao;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_movimentacoes")
@Getter
@Setter
public class Movimentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;

	private int quantidade;
	private Instant data;
	private String motivo;
	private String documento;

	public Movimentacao() {

	}

	public Movimentacao(Long id, Produto produto, TipoMovimentacao tipo, int quantidade, Instant data, String motivo,
			String documento) {
		super();
		this.id = id;
		this.produto = produto;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.data = data;
		this.motivo = motivo;
		this.documento = documento;
	}

}
