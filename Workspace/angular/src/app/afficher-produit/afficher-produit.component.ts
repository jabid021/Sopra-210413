import { Produit } from './../model/produit';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-afficher-produit',
  templateUrl: './afficher-produit.component.html',
  styleUrls: ['./afficher-produit.component.css'],
})
export class AfficherProduitComponent implements OnInit {
  @Input()
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}
}
