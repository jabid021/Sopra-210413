import { listeProduit } from './../produit';
import { Component, OnInit } from '@angular/core';
import { Produit } from '../model/produit';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent implements OnInit {
  produits: Produit[] = listeProduit;

  constructor() {}

  ngOnInit(): void {}

  infos(indice: number): string {
    if (this.produits[indice].prix > 0) return 'Positif';
    else if (this.produits[indice].prix === 0) return 'Neutre';
    else return 'Negatif';
  }

  recuperationEtAjout(produit: Produit) {
    this.produits.push(produit);
  }
}
