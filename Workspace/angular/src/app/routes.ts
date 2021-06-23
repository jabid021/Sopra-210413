import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';
import { ListProduitComponent } from './list-produit/list-produit.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ListProduitComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
