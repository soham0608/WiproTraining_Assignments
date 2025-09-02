import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Cart } from '../../interface/cart';
import { CartItem } from '../../interface/cart-item';
import { CartService } from '../../service/cart.service';
import { ProductService } from '../../service/product.service';
import { Router } from '@angular/router';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-cart',
  imports: [CommonModule, FormsModule, HeaderComponent],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css',
})
export class CartComponent implements OnInit {
  cart: Cart | null = null;
  cartItems: CartItem[] = [];
  totalPrice: number = 0;
  userId: number = 2;
  isLoading: boolean = false;

  constructor(
    private cartService: CartService,
    private productService: ProductService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadUserId();
    this.loadCart();
  }

  loadUserId(): void {
    this.userId = 0;

    const storedUserId = localStorage.getItem('userId');
    if (storedUserId) {
      this.userId = parseInt(storedUserId, 10);
      console.log('Cart - User ID from localStorage:', this.userId);
      return;
    }

    const userData = localStorage.getItem('user');
    if (userData) {
      try {
        const user = JSON.parse(userData);
        this.userId = user.id; 
        console.log('Cart - User ID from user data:', this.userId);
        
        localStorage.setItem('userId', this.userId.toString());
      } catch (e) {
        console.error('Error parsing user data:', e);
      }
    }

    console.log('Cart - Final user ID:', this.userId);
  }

  loadCart() {
    if (this.userId === 0) {
      console.error('Cannot load cart: User ID is 0');
      return;
    }

    this.isLoading = true;
    this.cartService.getCart(this.userId).subscribe({
      next: (cart) => {
        console.log('Cart data for user', this.userId, ':', cart);
        this.cart = cart;
        this.processCartItems(cart);
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Error loading cart:', error);
        this.isLoading = false;
      },
    });
  }

  processCartItems(cart: Cart) {
    this.cartItems = [];
    this.totalPrice = cart.totalPrice || 0;

    if (cart.prodDetails && Object.keys(cart.prodDetails).length > 0) {
      Object.entries(cart.prodDetails).forEach(([productId, quantity]) => {
        const pid = parseInt(productId);

        const item: CartItem = {
          productId: pid,
          quantity: quantity,
          product: null, 
        };

        this.cartItems.push(item);

        this.productService.getProductById(pid).subscribe({
          next: (product) => {
            item.product = product;
          },
          error: (error) => {
            console.error('Error loading product:', error);
            item.product = {
              id: pid,
              prodName: `Product ${pid}`,
              price: 0,
              prodCat: 'Unknown',
            };
          },
        });
      });
    }
  }

  updateQuantity(productId: number, newQuantity: number) {
    if (newQuantity <= 0) {
      this.removeItem(productId);
      return;
    }

    this.cartService
      .updateCartItem(this.userId, productId, newQuantity)
      .subscribe({
        next: (cart) => {
          this.cart = cart;
          this.processCartItems(cart);
        },
        error: (error) => {
          console.error('Error updating quantity:', error);
        },
      });
  }

  removeItem(productId: number) {
    this.cartService.removeFromCart(this.userId, productId).subscribe({
      next: () => {
        this.loadCart(); 
      },
      error: (error) => {
        console.error('Error removing item:', error);
      },
    });
  }

  proceedToCheckout() {
    this.router.navigate(['checkout']);
  }

  continueShopping() {
    this.router.navigate(['products']);
  }
}
