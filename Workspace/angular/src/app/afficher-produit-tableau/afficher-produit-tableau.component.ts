import { Produit } from './../model/produit';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'produit-tr,[produit-tr]',
  templateUrl: './afficher-produit-tableau.component.html',
  styleUrls: ['./afficher-produit-tableau.component.css'],
})
export class AfficherProduitTableauComponent implements OnInit {
  @Input()
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  get infos(): string {
    if (this.produit.prix > 0) return 'Positif';
    else if (this.produit.prix === 0) return 'Neutre';
    else return 'Negatif';
  }
}
