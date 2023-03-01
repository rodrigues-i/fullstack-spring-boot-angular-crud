import { Component, OnInit } from '@angular/core';
import { Produto } from 'src/app/models/produto';

@Component({
  selector: 'app-edit-produto',
  templateUrl: './edit-produto.component.html',
  styleUrls: ['./edit-produto.component.css']
})
export class EditProdutoComponent implements OnInit {
  produto: Produto = new Produto();

  constructor() { }

  ngOnInit(): void {
  }

  editProduto(): void {

  }
}
