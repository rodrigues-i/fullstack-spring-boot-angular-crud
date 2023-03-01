import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produto } from 'src/app/models/produto';
import { ProdutoService } from 'src/app/services/produto.service';

@Component({
  selector: 'app-edit-produto',
  templateUrl: './edit-produto.component.html',
  styleUrls: ['./edit-produto.component.css']
})
export class EditProdutoComponent implements OnInit {
  @Output() produto: Produto = new Produto();
  id: number;
  

  constructor(private route: ActivatedRoute, private produtoService: ProdutoService, private router: Router) { }

  ngOnInit(): void {
    this.id = parseInt(this.route.snapshot.paramMap.get("id"));
    this.editProduto();
  }

  editProduto(): void {
    this.produtoService.getProduto(this.id).subscribe(
      data => {
        this.produto = data;
      }
    );
  }

  updateProduto(produto: Produto): void {
    this.produtoService.updateProduto(produto).subscribe();
    this.router.navigateByUrl("/produtos")
      .then(() => {
        window.location.reload();
      });
  }
}