import { TestParametreComponent } from './test-parametre/test-parametre.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';
import { ListProduitComponent } from './list-produit/list-produit.component';
import { BonjourComponent } from './bonjour/bonjour.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'bonjour', component: BonjourComponent },
  { path: 'produits', component: ListProduitComponent },
  { path: 'param', component: TestParametreComponent },
  { path: 'param/:nom', component: TestParametreComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
