import { Produit } from './../model/produit';
import { Component, OnInit, HostListener } from '@angular/core';

@Component({
  selector: 'asc-bold,[asc-bold]',
  templateUrl: './asc-bold.component.html',
  styleUrls: ['./asc-bold.component.css'],
})
export class AscBoldComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  @HostListener('click')
  monAlert() {
    alert('on a cliqué');
  }

  methodeDuComponentCourant(produit: Produit) {
    console.log(produit);
  }
}
