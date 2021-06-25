import {
  AbstractControl,
  AsyncValidatorFn,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Fournisseur } from './../../model/fournisseur';
import { FournisseurService } from './../../services/fournisseur.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Adresse } from 'src/app/model/adresse';
import { Observable } from 'rxjs';
import { debounceTime, map } from 'rxjs/operators';

@Component({
  selector: 'app-edit-fournisseur',
  templateUrl: './edit-fournisseur.component.html',
  styleUrls: ['./edit-fournisseur.component.css'],
})
export class EditFournisseurComponent implements OnInit {
  fournisseur: Fournisseur = new Fournisseur();
  idCtrl: FormControl;
  prenomCtrl: FormControl;
  nomCtrl: FormControl;
  civiliteCtrl: FormControl;
  commentaireCtrl: FormControl;
  dateNaissanceCtrl: FormControl;
  numeroCtrl: FormControl;
  rueCtrl: FormControl;
  codePostalCtrl: FormControl;
  villeCtrl: FormControl;
  contactCtrl: FormControl;
  form: FormGroup;

  constructor(
    private fournisseurService: FournisseurService,
    private aR: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.idCtrl = this.fb.control('');
    this.prenomCtrl = this.fb.control('', [
      Validators.required,
      Validators.minLength(2),
    ]);
    this.nomCtrl = this.fb.control('', [
      Validators.required,
      Validators.minLength(2),
    ]);
    this.commentaireCtrl = this.fb.control('');
    this.civiliteCtrl = this.fb.control('M');
    this.dateNaissanceCtrl = this.fb.control('');
    this.numeroCtrl = this.fb.control('', Validators.required);
    this.rueCtrl = this.fb.control('', Validators.required);
    this.codePostalCtrl = this.fb.control('', Validators.required);
    this.villeCtrl = this.fb.control('', Validators.required);
    this.contactCtrl = this.fb.control(
      '',
      [Validators.required, Validators.email],
      this.checkMail()
    );
    this.form = this.fb.group({
      id: this.idCtrl,
      prenom: this.prenomCtrl,
      nom: this.nomCtrl,
      civilite: this.civiliteCtrl,
      dateNaissance: this.dateNaissanceCtrl,
      numero: this.numeroCtrl,
      rue: this.rueCtrl,
      codePostal: this.codePostalCtrl,
      ville: this.villeCtrl,
      contact: this.contactCtrl,
    });
  }

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (params.id) {
        this.fournisseurService.get(params.id).subscribe((data) => {
          this.fournisseur = data;
          this.idCtrl.setValue(this.fournisseur.id);
          this.prenomCtrl.setValue(this.fournisseur.prenom);
          this.nomCtrl.setValue(this.fournisseur.nom);
          this.civiliteCtrl.setValue(this.fournisseur.civilite);
          this.codePostalCtrl.setValue(this.fournisseur.adresse.codePostal);
          this.rueCtrl.setValue(this.fournisseur.adresse.rue);
          this.villeCtrl.setValue(this.fournisseur.adresse.ville);
          this.numeroCtrl.setValue(this.fournisseur.adresse.numero);
          this.commentaireCtrl.setValue(this.fournisseur.commentaire);
          this.dateNaissanceCtrl.setValue(this.fournisseur.dateNaissance);
          this.contactCtrl.setValue(this.fournisseur.contact);
        });
      }
    });
  }

  checkMail(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.fournisseurService.checkMail(control.value).pipe(
        debounceTime(500),
        map((fournisseur: Fournisseur) => {
          if (this.fournisseur.contact != fournisseur.contact) {
            return fournisseur.id ? { mailExist: true } : null;
          } else {
            return null;
          }
        })
      );
    };
  }

  save() {
    this.fournisseur = new Fournisseur(
      this.idCtrl.value,
      this.prenomCtrl.value,
      this.nomCtrl.value,
      this.commentaireCtrl.value,
      this.civiliteCtrl.value,
      this.contactCtrl.value,
      new Adresse(
        this.numeroCtrl.value,
        this.rueCtrl.value,
        this.codePostalCtrl.value,
        this.villeCtrl.value
      ),
      this.dateNaissanceCtrl.value
    );
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
