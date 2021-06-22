import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProduitComponent } from './produit/produit.component';
import { FormsModule } from '@angular/forms';
import { CouleurComponent } from './couleur/couleur.component';
import { TestComponent } from './test/test.component';
import { OutputComponent } from './output/output.component';
import { AscBoldComponent } from './asc-bold/asc-bold.component';
import { AscBoldElementComponent } from './asc-bold-element/asc-bold-element.component';
import { AscTooltipComponent } from './asc-tooltip/asc-tooltip.component';
import { SaisirProduitComponent } from './saisir-produit/saisir-produit.component';

@NgModule({
  declarations: [AppComponent, ProduitComponent, CouleurComponent, TestComponent, OutputComponent, AscBoldComponent, AscBoldElementComponent, AscTooltipComponent, SaisirProduitComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}