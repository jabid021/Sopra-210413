import { Fournisseur } from './../../model/fournisseur';
import { FournisseurService } from './../../services/fournisseur.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-fournisseur',
  templateUrl: './edit-fournisseur.component.html',
  styleUrls: ['./edit-fournisseur.component.css'],
})
export class EditFournisseurComponent implements OnInit {
  fournisseur: Fournisseur = new Fournisseur();

  constructor(
    private fournisseurService: FournisseurService,
    private aR: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params.id) {
        this.fournisseurService.get(params.id).subscribe((data) => {
          this.fournisseur = data;
        });
      }
    });
  }

  save() {
    if (this.fournisseur.id) {
      this.fournisseurService.update(this.fournisseur).subscribe((resut) => {
        this.router.navigate(['/fournisseurs']);
      });
    } else {
      this.fournisseurService.create(this.fournisseur).subscribe((result) => {
        this.router.navigate(['/fournisseurs']);
      });
    }
  }
}
