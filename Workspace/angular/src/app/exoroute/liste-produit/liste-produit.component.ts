import { listeProduit } from './../../produit';
import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/model/produit';

@Component({
  selector: 'app-liste-produit',
  templateUrl: './liste-produit.component.html',
  styleUrls: ['./liste-produit.component.css'],
})
export class ListeProduitComponent implements OnInit {
  produits: Produit[] = listeProduit;

  constructor() {}

  ngOnInit(): void {}

  delete(index: number) {
    this.produits.splice(index, 1);
  }
}
