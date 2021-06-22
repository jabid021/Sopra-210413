import { Produit } from './../model/produit';
import { Component, HostListener, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css'],
})
export class TestComponent implements OnInit {
  @Input()
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  @HostListener('click')
  methode() {
    this.produit.nom = 'click';
  }

  // @HostListener('mouseover')
  // mouseOver() {
  //   console.log('over');
  // }
}
