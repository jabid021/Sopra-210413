import { Fournisseur } from './../model/fournisseur';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { getLocaleTimeFormat } from '@angular/common';

@Injectable({
  providedIn: 'root',
})
export class FournisseurService {
  private static URL: string = 'http://localhost:8080/boot/api/fournisseur';

  private httpHeader: HttpHeaders | any = null;

  constructor(private http: HttpClient) {}

  private initHeader() {
    const auth=localStorage.getItem('auth');
    this.httpHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: auth?auth:'',
    });
  }

  public getAll(): Observable<Fournisseur[]> {
    this.initHeader();
    return this.http.get<Fournisseur[]>(FournisseurService.URL, {
      headers: this.httpHeader,
    });
  }

  public get(id: number): Observable<Fournisseur> {
    this.initHeader();
    return this.http.get<Fournisseur>(`${FournisseurService.URL}/${id}`, {
      headers: this.httpHeader,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(`${FournisseurService.URL}/${id}`, {
      headers: this.httpHeader,
    });
  }
  public update(fournisseur: Fournisseur): Observable<Fournisseur> {
    this.initHeader();
    const f = {
      prenom: fournisseur.prenom,
      nom: fournisseur.nom,
      civilite: fournisseur.civilite,
      dateNaissance: fournisseur.dateNaissance,
      commentaire: fournisseur.commentaire,
      adresse: {
        numero: fournisseur.adresse.numero,
        rue: fournisseur.adresse.rue,
        codePostal: fournisseur.adresse.codePostal,
        ville: fournisseur.adresse.ville,
      },
      contact: fournisseur.contact,
    };
    return this.http.put<Fournisseur>(
      `${FournisseurService.URL}/${fournisseur.id}`,
      f,
      {
        headers: this.httpHeader,
      }
    );
  }

  public create(fournisseur: Fournisseur): Observable<Fournisseur> {
    this.initHeader();
    const f = {
      prenom: fournisseur.prenom,
      nom: fournisseur.nom,
      civilite: fournisseur.civilite,
      dateNaissance: fournisseur.dateNaissance,
      commentaire: fournisseur.commentaire,
      adresse: {
        numero: fournisseur.adresse.numero,
        rue: fournisseur.adresse.rue,
        codePostal: fournisseur.adresse.codePostal,
        ville: fournisseur.adresse.ville,
      },
      contact: fournisseur.contact,
    };
    console.log(f);
    return this.http.post<Fournisseur>(FournisseurService.URL, f, {
      headers: this.httpHeader,
    });
  }

  public checkMail(contact: string): Observable<Fournisseur> {
    this.initHeader();
    return this.http.get<Fournisseur>(
      `${FournisseurService.URL}/contact/${contact}`,
      { headers: this.httpHeader }
    );
  }
}
