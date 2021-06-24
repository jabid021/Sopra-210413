import { Produit } from './../model/produit';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ProduitLocalService {
  private produits: Produit[] = [
    new Produit('tele', 500),
    new Produit('avion', -999999),
  ];

  constructor() {}

  public getAll(): Produit[] {
    return this.produits;
  }

  public get(index: number): Produit {
    return this.produits[index];
  }

  public add(produit: Produit) {
    this.produits.push(produit);
  }

  public update(produit: Produit, index: number) {
    this.produits[index] = produit;
  }

  public delete(index: number) {
    this.produits.splice(index, 1);
  }
}
