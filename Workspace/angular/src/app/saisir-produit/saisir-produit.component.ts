import { Produit } from './../model/produit';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-saisir-produit',
  templateUrl: './saisir-produit.component.html',
  styleUrls: ['./saisir-produit.component.css'],
})
export class SaisirProduitComponent implements OnInit {
  produit: Produit = new Produit();
  @Output('produitPret')
  sendProduit: EventEmitter<Produit> = new EventEmitter<Produit>();
  constructor() {}

  ngOnInit(): void {}

  send() {
    this.sendProduit.emit(this.produit);
    this.produit = new Produit();
  }
}
