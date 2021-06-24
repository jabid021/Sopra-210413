import { Observable } from 'rxjs';
import { Produit } from './../model/produit';
import { ProduitService } from './../service/produit.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent implements OnInit {
  produits: Observable<Produit[]> | any = null;
  //produits:Produit[]=[];
  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    // this.produitService.getAll().subscribe((data) => {
    //   this.produits = data;
    //   console.log(data);
    // });
    this.produits = this.produitService.getAll();
  }

  delete(id: number) {
    this.produitService.delete(id).subscribe((result) => {
      this.produits = this.produitService.getAll();
    });
  }
}
