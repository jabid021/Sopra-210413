import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-couleur',
  templateUrl: './couleur.component.html',
  styleUrls: ['./couleur.component.css'],
})
export class CouleurComponent implements OnInit {
  couleur: string = '#000000';
  @Input('color')
  color: string;

  constructor() {
    console.log('color dans constructeur:' + this.color);
  }

  ngOnInit(): void {
    console.log('color dans ngOnInit:' + this.color);
    if (this.color) {
      this.couleur = this.color;
    }
  }
}
