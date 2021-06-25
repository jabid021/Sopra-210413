import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'angular-final';

  constructor(private router: Router) {}

  isLogged(): boolean {
    return localStorage.getItem('login') ? true : false;
  }

  logoff() {
    localStorage.clear();
    this.router.navigate(['/home']);
  }
}
