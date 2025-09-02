import { Component } from '@angular/core';
import { LoginService } from '../../service/login.service';
import { Router, RouterLink } from '@angular/router';
import { Login } from '../../interface/login';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  user: Login = {
    firstName: '',
    lastName: '',
    emailId: '',
    userId: '',
    phone: undefined,
    passWord: '',
    address: '',
    userType: 1,
    isLoggedIn: false,
  };

  isLoading: boolean = false;

  constructor(private loginService: LoginService, private router: Router) {}

  onRegister() {
    this.isLoading = true;
    this.loginService.register(this.user).subscribe(() => {
      alert('Registration successful! Please login.');
      this.router.navigate(['/login']);
    });
  }
}
