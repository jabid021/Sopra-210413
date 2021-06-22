import { Produit } from './model/produit';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'angular';
  unProduit: Produit = new Produit('tele', 100);

  recuperationProduit(produitRecu: Produit) {
    this.unProduit = produitRecu;
  }
}
