import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Produto } from '../models/produto';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  private url: string = "http://localhost:8081/server/produtos";
  constructor(private httpClient: HttpClient) { }

  getProdutos(): Observable<Produto[]> {
    return this.httpClient.get<Produto[]>(this.url).pipe(
      map(response => response)
    );
  };

  postProduto(produto: Produto): Observable<Produto> {
    return this.httpClient.post<Produto>(this.url, produto);
  };

  getProduto(id: number): Observable<Produto> {
    return this.httpClient.get<Produto>(this.url + "/" + id);
  };

  updateProduto(produto: Produto): Observable<Produto> {
    return this.httpClient.put<Produto>(this.url + "/" + produto.id, produto);
  };

  deleteProduto(id: number): Observable<Produto> {
    return this.httpClient.delete<Produto>(this.url + "/" + id);
  }
}
