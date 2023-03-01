import { Component, OnInit, Input } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Produto } from 'src/app/models/produto';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @Input() produtos: Produto[];
  displayedColumns: string[] = ['codigo', 'nome', 'quantidadeMinima', 'saldoInicial', 'editar'];
  dataSource: MatTableDataSource<Produto>;
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.dataSource  = new MatTableDataSource<Produto>(this.produtos);
  }

  edit(produto: Produto): void {
    this.router.navigateByUrl("/produtos/" + produto.id);
    
  }
}