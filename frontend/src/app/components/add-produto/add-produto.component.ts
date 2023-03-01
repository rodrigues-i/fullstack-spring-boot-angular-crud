import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Component, OnInit, Input } from '@angular/core';
import { Produto } from 'src/app/models/produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-add-produto',
  templateUrl: './add-produto.component.html',
  styleUrls: ['./add-produto.component.css']
})
export class AddProdutoComponent implements OnInit {
  produto: Produto = new Produto();

  constructor(private produtoService: ProdutoService, private router: Router) { }

  ngOnInit(): void {
  }

  saveProduto(): void {
    this.produtoService.postProduto(this.produto).subscribe();
    this.router.navigateByUrl("/produtos");

  }
}
