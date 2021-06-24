import { ProduitLocalService } from './../../services/produit-local.service';
import { listeProduit } from './../../produit';
import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/app/model/produit';

@Component({
  selector: 'app-liste-produit',
  templateUrl: './liste-produit.component.html',
  styleUrls: ['./liste-produit.component.css'],
})
export class ListeProduitComponent implements OnInit {
  produits: Produit[] = [];

  constructor(private produitService:ProduitLocalService) {}

  ngOnInit(): void {
    this.produits=this.produitService.getAll();
  }

  delete(index: number) {
    this.produitService.delete(index);
  }
}
