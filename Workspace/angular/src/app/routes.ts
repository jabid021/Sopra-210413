import { DetailProduitComponent } from './exoroute/detail-produit/detail-produit.component';
import { TestParametreComponent } from './test-parametre/test-parametre.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';
import { ListProduitComponent } from './list-produit/list-produit.component';
import { BonjourComponent } from './bonjour/bonjour.component';
import { ListeProduitComponent } from './exoroute/liste-produit/liste-produit.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'bonjour', component: BonjourComponent },
  { path: 'produits', component: ListeProduitComponent },
  { path: 'produits/detail', component: DetailProduitComponent },
  { path: 'produits/detail/:index', component: DetailProduitComponent },
  { path: 'param', component: TestParametreComponent },
  { path: 'param/:nom', component: TestParametreComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
