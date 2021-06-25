import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  public login(login: string, password: string): Observable<boolean> {
    const header = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa(`${login}:${password}`),
    });
    return this.http.get<boolean>('http://localhost:8080/boot/api/login', {
      headers: header,
    });
  }
}
