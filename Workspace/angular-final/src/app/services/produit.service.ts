import { Produit } from './../model/produit';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  private static URL = 'http://localhost:8080/boot/api/produit';
  private httpHeader: HttpHeaders | any = null;

  constructor(private http: HttpClient) {}

  private initHeader() {
    const auth = localStorage.getItem('auth');
    this.httpHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: auth ? auth : '',
    });
  }

  public getAll(): Observable<Produit[]> {
    this.initHeader();
    return this.http.get<Produit[]>(ProduitService.URL, {
      headers: this.httpHeader,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(ProduitService.URL + '/' + id, {
      headers: this.httpHeader,
    });
  }

  public get(id: number): Observable<Produit> {
    this.initHeader();
    return this.http.get<Produit>(ProduitService.URL + '/' + id, {
      headers: this.httpHeader,
    });
  }

  public create(produit: Produit): Observable<Produit> {
    this.initHeader();
    const produitFormate = {
      nom: produit.nom,
      prix: produit.prix,
    };

    return this.http.post<Produit>(ProduitService.URL, produitFormate, {
      headers: this.httpHeader,
    });
  }

  public update(produit: Produit): Observable<Produit> {
    this.initHeader();
    console.log(produit);
    return this.http.put<Produit>(
      ProduitService.URL + '/' + produit.id,
      produit,
      { headers: this.httpHeader }
    );
  }
}
