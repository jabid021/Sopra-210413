import { Produit } from './../model/produit';
import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent implements OnInit {
  produit: Produit = new Produit();
  message = '';
  image: string = '/assets/img1.jpeg';
  couleur: string = 'pink';

  constructor() {}

  ngOnInit(): void {}

  methodeDuComponent() {
    this.message = 'click sur le bouton';
    console.log(this.message);
  }

  loadImage(image: string) {
    this.image = '/assets/' + image + '.jpeg';
  }

  showProduit(): boolean {
    return (
      this.produit.nom !== '' &&
      this.produit.prix !== 0 &&
      this.produit.prix != null
    );
  }
}
