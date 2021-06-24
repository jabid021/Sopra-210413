import { Footer1Component } from './footer1/footer1.component';
import { DetailProduitComponent } from './exoroute/detail-produit/detail-produit.component';
import { TestParametreComponent } from './test-parametre/test-parametre.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';
import { ListProduitComponent } from './list-produit/list-produit.component';
import { BonjourComponent } from './bonjour/bonjour.component';
import { ListeProduitComponent } from './exoroute/liste-produit/liste-produit.component';
import { Footer2Component } from './footer2/footer2.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'bonjour', component: BonjourComponent },
  { path: 'demoPipe', component: ListProduitComponent },
  { path: 'produits', component: ListeProduitComponent },
  { path: 'produits/detail', component: DetailProduitComponent },
  { path: 'produits/detail/:index', component: DetailProduitComponent },
  { path: 'param', component: TestParametreComponent },
  { path: 'param/:nom', component: TestParametreComponent },
  { path: 'footer1', component: Footer1Component, outlet: 'footer' },
  { path: 'footer2', component: Footer2Component, outlet: 'footer' },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
