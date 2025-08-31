// app.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" routerLink="/">Mini Ecommerce</a>
      <ul class="navbar-nav ms-auto">
        <li class="nav-item"><a class="nav-link" routerLink="/login">Login</a></li>
        <li class="nav-item"><a class="nav-link" routerLink="/register">Register</a></li>
      </ul>
    </div>
  </nav>
  <div class="container mt-4">
    <router-outlet></router-outlet>
  </div>
  `
})
export class AppComponent {}
