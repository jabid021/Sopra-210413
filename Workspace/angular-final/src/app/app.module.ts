import { routes } from './routes';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ListProduitComponent } from './list-produit/list-produit.component';
import { HomeComponent } from './home/home.component';
import { EditProduitComponent } from './edit-produit/edit-produit.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ListFournisseurComponent } from './fournisseur/list-fournisseur/list-fournisseur.component';
import { EditFournisseurComponent } from './fournisseur/edit-fournisseur/edit-fournisseur.component';
import { FormulaireTemplateComponent } from './formulaire/formulaire-template/formulaire-template.component';

@NgModule({
  declarations: [
    AppComponent,
    ListProduitComponent,
    HomeComponent,
    EditProduitComponent,
    ListFournisseurComponent,
    EditFournisseurComponent,
    FormulaireTemplateComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
