import { Injectable } from '@angular/core';
import { CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurConnecteService implements CanActivate {
  constructor() {}

  canActivate(): boolean {
    if (localStorage.getItem('auth')) {
      return true;
    } else {
      return false;
    }
  }
}
