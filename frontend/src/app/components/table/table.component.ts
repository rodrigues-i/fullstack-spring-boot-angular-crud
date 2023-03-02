import { Component, OnInit, Input } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Produto } from 'src/app/models/produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @Input() produtos: Produto[];
  displayedColumns: string[] = ['codigo', 'nome', 'quantidadeMinima', 'saldoInicial', 'editar'];
  dataSource: MatTableDataSource<Produto>;
  constructor(private router: Router, private produtoService: ProdutoService) { }

  ngOnInit(): void {
    this.dataSource  = new MatTableDataSource<Produto>(this.produtos);
  }

  edit(produto: Produto): void {
    this.router.navigateByUrl("/produtos/" + produto.id);
  }

  removeProduto(id: number): void {
    this.produtoService.deleteProduto(id).subscribe();
    window.location.reload();
  }
}