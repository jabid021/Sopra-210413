import { Civilite } from './../../model/civilite';
import { Observable } from 'rxjs';
import { FournisseurService } from './../../services/fournisseur.service';
import { Component, OnInit } from '@angular/core';
import { Fournisseur } from 'src/app/model/fournisseur';

@Component({
  selector: 'app-list-fournisseur',
  templateUrl: './list-fournisseur.component.html',
  styleUrls: ['./list-fournisseur.component.css'],
})
export class ListFournisseurComponent implements OnInit {
  fournisseurs: Observable<Fournisseur> | any = null;

  constructor(private fournisseurService: FournisseurService) {}

  ngOnInit(): void {
    this.initFournisseur();
  }

  initFournisseur() {
    this.fournisseurs = this.fournisseurService.getAll();
  }

  delete(id: number) {
    this.fournisseurService.delete(id).subscribe((result) => {
      this.initFournisseur();
    });
  }
}
