import { Component } from '@angular/core';
import { ProductService } from '../../service/product.service';
import { CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CartService } from '../../service/cart.service';
import { Router } from '@angular/router';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-product',
  imports: [CurrencyPipe, FormsModule, HeaderComponent],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css',
})
export class ProductComponent {
  products: any[] = [];
  filteredProducts: any[] = [];
  searchCategory: string = '';
  searchText: string = '';
  userId: number = 1; 
  isLoading: boolean = false;
  errorMessage: string = '';

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadUserId();
    this.loadProducts();
  }

  loadUserId(): void {
    this.userId = 0;

    const storedUserId = localStorage.getItem('userId');
    if (storedUserId) {
      this.userId = parseInt(storedUserId, 10);
      console.log('User ID from localStorage:', this.userId);
      return;
    }

    const userData = localStorage.getItem('user');
    if (userData) {
      try {
        const user = JSON.parse(userData);
        this.userId = user.id;
        console.log('User ID from user data:', this.userId);
        localStorage.setItem('userId', this.userId.toString());
      } catch (e) {
        console.error('Error parsing user data:', e);
      }
    }

    console.log('Final user ID:', this.userId);
  }

  loadProducts(): void {
    this.isLoading = true;
    this.errorMessage = '';

    this.productService.getAllProducts().subscribe(
      (data: any[]) => {
        this.products = data;
        this.filteredProducts = data;
        this.isLoading = false;
      },
      (error) => {
        console.error('Error loading products', error);
        this.errorMessage = 'Failed to load products. Please try again later.';
        this.isLoading = false;
      }
    );
  }

  addToCart(product: any): void {
    if (this.userId === 0) {
      alert('Please log in again. User ID not found.');
      this.router.navigate(['/login']);
      return;
    }

    console.log('Adding to cart with userId:', this.userId);

    this.cartService.addToCart(this.userId, product.id, 1).subscribe(
      (response: any) => {
        console.log('Add to cart response:', response);
        alert('Product added to cart successfully!');
      },
      (error) => {
        console.error('Error adding to cart', error);
        alert('Failed to add product to cart');
      }
    );
  }

  search(): void {
    this.isLoading = true;
    this.errorMessage = '';

    if (this.searchCategory || this.searchText) {
      this.productService
        .searchProducts(this.searchCategory, this.searchText)
        .subscribe(
          (data: any[] | null) => {
            if (data === null) {
              this.filterProductsLocally();
            } else {
              this.filteredProducts = data;
            }
            this.isLoading = false;
          },
          (error) => {
            console.error('Error searching products', error);
            this.filterProductsLocally();
            this.isLoading = false;
          }
        );
    } else {
      this.filteredProducts = this.products;
      this.isLoading = false;
    }
  }

  filterProductsLocally(): void {
    this.filteredProducts = this.products.filter((product) => {
      const matchesCategory =
        !this.searchCategory ||
        product.prodCat
          .toLowerCase()
          .includes(this.searchCategory.toLowerCase());

      const matchesSearch =
        !this.searchText ||
        product.prodName
          .toLowerCase()
          .includes(this.searchText.toLowerCase()) ||
        (product.prodDesc &&
          product.prodDesc
            .toLowerCase()
            .includes(this.searchText.toLowerCase()));

      return matchesCategory && matchesSearch;
    });
  }
}
