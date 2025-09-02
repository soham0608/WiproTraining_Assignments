import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Login } from '../../interface/login';
import { TokenData } from '../../interface/token';
import { LoginService } from '../../service/login.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [FormsModule, RouterLink, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  login: Login = {
    emailId: '',
    firstName: '',
    lastName: '',
    passWord: '',
    userId: '',
    phone: 0,
    address: '',
    userType: 1,
    isLoggedIn: false,
  };

  jwttoken: TokenData = {
    token: '',
    role: '',
  };

  isLoading: boolean = false;

  constructor(private loginService: LoginService, private router: Router) {}

  onLogin() {
    console.log('userId=' + this.login.userId);
    console.log('password=' + this.login.passWord);

    this.isLoading = true; 

    this.loginService.login(this.login).subscribe({
      next: (data) => {
        this.jwttoken = data;

        let tokenvalue = this.jwttoken.token;
        let rolevalue = this.jwttoken.role;

        localStorage.setItem('token', tokenvalue);
        localStorage.setItem('role', rolevalue);

        const userId = localStorage.getItem('userId');
        console.log('Logged in with user ID:', userId);

        if (rolevalue === 'ADMIN') {
          this.router.navigate([`/user/menu/0`]);
        } else if (rolevalue === 'CUSTOMER') {
          this.router.navigate([`/user/menu/1`]);
        } else {
          this.router.navigate(['/products']);
        }
      },
      error: (error) => {
        console.error('Login error:', error);
        this.isLoading = false; 
        alert('Login failed. Please check your credentials.');
      },
    });
  }
}
