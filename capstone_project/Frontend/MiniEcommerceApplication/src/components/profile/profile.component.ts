import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../../service/login.service';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-profile',
  imports: [CommonModule, FormsModule, HeaderComponent],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css',
})
export class ProfileComponent {
  user: any = {
    id: 0,
    firstName: '',
    lastName: '',
    userId: '',
    emailId: '',
    address: '',
    phone: '',
    password: '',
    confirmPassword: '',
  };

  isEditing = false;
  message = '';

  constructor(private userService: LoginService, private router: Router) {}

  ngOnInit(): void {
    this.loadUserData();
  }

  loadUserData() {
    const userData = localStorage.getItem('user');
    if (userData) {
      this.user = {
        ...JSON.parse(userData),
        password: '',
        confirmPassword: '',
      };
    }
  }

  toggleEdit() {
    this.isEditing = !this.isEditing;
    if (!this.isEditing) {
      this.loadUserData(); 
    }
  }

  updateProfile() {
    if (this.user.password !== this.user.confirmPassword) {
      this.message = 'Passwords do not match!';
      return;
    }

    const { confirmPassword, ...userToUpdate } = this.user;

    this.userService.updateUser(this.user.id, userToUpdate).subscribe({
      next: (updatedUser) => {
        localStorage.setItem('user', JSON.stringify(updatedUser));

        this.isEditing = false;
        this.message = 'Profile updated successfully!';

        this.user.password = '';
        this.user.confirmPassword = '';
      },
      error: (error) => {
        console.error('Error updating profile:', error);
        this.message = 'Failed to update profile';
      },
    });
  }

  goBack() {
    this.router.navigate(['/products']);
  }
}
