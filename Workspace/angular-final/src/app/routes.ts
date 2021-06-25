import { EditFournisseurComponent } from './fournisseur/edit-fournisseur/edit-fournisseur.component';
import { ListFournisseurComponent } from './fournisseur/list-fournisseur/list-fournisseur.component';
import { HomeComponent } from './home/home.component';
import { EditProduitComponent } from './edit-produit/edit-produit.component';
import { ListProduitComponent } from './list-produit/list-produit.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'fournisseurs', component: ListFournisseurComponent },
  { path: 'fournisseurs/edit', component: EditFournisseurComponent },
  { path: 'fournisseurs/edit/:id', component: EditFournisseurComponent },
  { path: 'produits', component: ListProduitComponent },
  { path: 'produits/edit', component: EditProduitComponent },
  { path: 'produits/edit/:id', component: EditProduitComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
