import { Produit } from './model/produit';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'angular';

  produits: Produit[] = [new Produit('tele', 300), new Produit('velo', 100)];
}
