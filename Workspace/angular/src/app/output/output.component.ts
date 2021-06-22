import { Produit } from './../model/produit';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.css'],
})
export class OutputComponent implements OnInit {
  p: Produit = null;

  @Output('produitCree')
  produitCree: EventEmitter<Produit> = new EventEmitter<Produit>();

  constructor() {}

  ngOnInit(): void {}

  creationDUnProduit() {
    this.p = new Produit('produit cree par le component output', 1000);
    this.produitCree.emit(this.p);
  }
}
