import { ProduitLocalService } from './../../services/produit-local.service';
import { listeProduit } from './../../produit';
import { Produit } from './../../model/produit';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detail-produit',
  templateUrl: './detail-produit.component.html',
  styleUrls: ['./detail-produit.component.css'],
})
export class DetailProduitComponent implements OnInit {
  produit: Produit = new Produit();
  index: number = -1;

  constructor(
    private produitService: ProduitLocalService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params.index) {
        this.index = params.index;
        this.produit = this.produitService.get(this.index);
      }
    });
  }

  save() {
    if (this.index === -1) {
      this.produitService.add(this.produit);
    } else {
      this.produitService.update(this.produit, this.index);
    }
    this.produit = new Produit();
    this.router.navigate(['/produits']);
  }
}
