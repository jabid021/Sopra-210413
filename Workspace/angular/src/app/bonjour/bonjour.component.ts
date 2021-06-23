import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bonjour',
  templateUrl: './bonjour.component.html',
  styleUrls: ['./bonjour.component.css'],
})
export class BonjourComponent implements OnInit {
  nom: string = '';

  constructor(private router: Router) {}

  ngOnInit(): void {}

  go() {
    this.router.navigate(['/param', this.nom], {
      queryParams: { prenom: this.nom },
    });
  }
}
