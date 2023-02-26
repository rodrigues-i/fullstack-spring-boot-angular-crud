import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/models/produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-list-produtos',
  templateUrl: './list-produtos.component.html',
  styleUrls: ['./list-produtos.component.css']
})
export class ListProdutosComponent implements OnInit {
  produtos: Produto[] = [];
  constructor(private produtoService: ProdutoService) { }

  ngOnInit(): void {
    this.listProdutos();
  }

  listProdutos(): void {
    this.produtoService.getProdutos().subscribe(
      data => this.produtos = data
    );
  };
}
