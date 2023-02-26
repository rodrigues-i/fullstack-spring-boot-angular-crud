import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListProdutosComponent } from './components/list-produtos/list-produtos.component';
import { LoginComponent } from './components/login/login.component';


const routes: Routes = [
  {path: 'produtos', component: ListProdutosComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
