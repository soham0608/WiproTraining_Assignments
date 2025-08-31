import { Component, OnInit } from '@angular/core';
import { OrderService, CartItem } from '../../../services/order.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {
  cartItems: CartItem[] = [];
  userId = 1; // get from login or localStorage

  constructor(private orderService: OrderService) {}

  ngOnInit() {
    this.loadCart();
  }

  loadCart() {
    this.orderService.getCartItems(this.userId).subscribe({
      next: (data) => (this.cartItems = data),
      error: (err) => console.error(err)
    });
  }

  removeItem(cartId: number) {
    this.orderService.deleteCartItem(cartId).subscribe(() => this.loadCart());
  }

  placeOrder() {
    this.orderService.createOrder(this.userId).subscribe({
      next: () => this.loadCart(),
      error: (err) => console.error(err)
    });
  }
}
