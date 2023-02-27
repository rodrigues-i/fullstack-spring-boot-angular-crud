import { Component, OnInit, Input } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Produto } from 'src/app/models/produto';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @Input() produtos: Produto[];
  displayedColumns: string[] = ['codigo', 'nome', 'quantidadeMinima', 'saldoInicial'];
  dataSource: MatTableDataSource<Produto>;
  constructor() { }

  ngOnInit(): void {
    console.log("produtos: ", this.produtos);
    this.dataSource  = new MatTableDataSource<Produto>(this.produtos);
  }
}