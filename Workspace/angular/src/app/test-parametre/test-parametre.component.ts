import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-test-parametre',
  templateUrl: './test-parametre.component.html',
  styleUrls: ['./test-parametre.component.css'],
})
export class TestParametreComponent implements OnInit {
  nom: string = 'le monde';

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params.nom) {
        console.log(params.nom);
        this.nom = params.nom;
      }
    });
    this.activatedRoute.queryParams.subscribe((params) => {
      console.log(params);
    });
  }
}
