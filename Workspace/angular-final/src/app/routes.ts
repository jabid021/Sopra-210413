import { UtilisateurConnecteService } from './services/utilisateur-connecte.service';
import { LoginComponent } from './login/login.component';
import { EditFournisseurComponent } from './fournisseur/edit-fournisseur/edit-fournisseur.component';
import { ListFournisseurComponent } from './fournisseur/list-fournisseur/list-fournisseur.component';
import { HomeComponent } from './home/home.component';
import { EditProduitComponent } from './edit-produit/edit-produit.component';
import { ListProduitComponent } from './list-produit/list-produit.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'fournisseurs',
    component: ListFournisseurComponent,
    canActivate: [UtilisateurConnecteService],
  },
  { path: 'login', component: LoginComponent },
  {
    path: 'fournisseurs/edit',
    component: EditFournisseurComponent,
    canActivate: [UtilisateurConnecteService],
  },
  {
    path: 'fournisseurs/edit/:id',
    component: EditFournisseurComponent,
    canActivate: [UtilisateurConnecteService],
  },
  {
    path: 'produits',
    component: ListProduitComponent,
    canActivate: [UtilisateurConnecteService],
  },
  {
    path: 'produits/edit',
    component: EditProduitComponent,
    canActivate: [UtilisateurConnecteService],
  },
  {
    path: 'produits/edit/:id',
    component: EditProduitComponent,
    canActivate: [UtilisateurConnecteService],
  },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
