import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProduitComponent } from './produit/produit.component';
import { FormsModule } from '@angular/forms';
import { CouleurComponent } from './couleur/couleur.component';
import { TestComponent } from './test/test.component';
import { OutputComponent } from './output/output.component';

@NgModule({
  declarations: [AppComponent, ProduitComponent, CouleurComponent, TestComponent, OutputComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
