import { Produit } from './../model/produit';
import { ProduitService } from './../service/produit.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css'],
})
export class EditProduitComponent implements OnInit {
  produit: Produit = new Produit();

  constructor(
    private produitService: ProduitService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.produitService.get(params.id).subscribe((data) => {
          this.produit = data;
        });
      }
    });
  }

  save() {
    if (this.produit.id) {
      this.produitService.update(this.produit).subscribe((res) => {
        this.router.navigate(['/produits'], {
          queryParams: { update: this.produit.id },
        });
      });
    } else {
      this.produitService.create(this.produit).subscribe((res) => {
        this.router.navigate(['/produits'], {
          queryParams: { create: res.id },
        });
      });
    }
  }
}
