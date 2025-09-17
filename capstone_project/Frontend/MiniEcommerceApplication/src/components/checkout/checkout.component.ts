import { CommonModule } from '@angular/common';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { OrderService } from '../../service/order.service';
import { CartService } from '../../service/cart.service';
import { Router } from '@angular/router';
import { HeaderComponent } from '../header/header.component';
import { Order } from '../../interface/order';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-checkout',
  imports: [CommonModule, HeaderComponent, FormsModule],
  templateUrl: './checkout.component.html',
  styleUrl: './checkout.component.css',
})
export class CheckoutComponent implements OnInit, OnDestroy {
  userId: number = 0;
  isLoading: boolean = false;
  errorMessage: string = '';
  currentOrder?: Order;
  pollingInterval: any;

  constructor(
    private orderService: OrderService,
    private cartService: CartService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadUserId();
  }

  ngOnDestroy(): void {
    if (this.pollingInterval) {
      clearInterval(this.pollingInterval);
    }
  }

  loadUserId(): void {
    const storedUserId = localStorage.getItem('userId');
    if (storedUserId) {
      this.userId = parseInt(storedUserId, 10);
    }
  }

  placeOrder(): void {
    if (this.userId === 0) {
      alert('Please log in to place an order');
      this.router.navigate(['/login']);
      return;
    }

    this.isLoading = true;
    this.errorMessage = '';

    this.orderService.createOrder(this.userId).subscribe({
      next: (order) => {
        console.log('Order placed successfully:', order);
        this.currentOrder = order;

        this.checkOrderStatus(order.orderId);

        setTimeout(() => {
          if (this.currentOrder) {
            this.orderService
              .updateOrderStatus(this.currentOrder.orderId, 'CONFIRMED')
              .subscribe({
                next: (updatedOrder) => {
                  console.log('Order status updated in DB:', updatedOrder);
                  this.currentOrder = updatedOrder;

                  // ✅ Clear cart once order is confirmed
                  this.cartService.clearCart(this.userId).subscribe({
                    next: () => {
                      console.log('Cart cleared after order placed');
                    },
                    error: (error) => {
                      console.error('Failed to clear cart:', error);
                    },
                  });
                },
                error: (error) => {
                  console.error('Failed to update order status:', error);
                },
              });
          }
        }, 1000);
      },
      error: (error) => {
        console.error('Error creating order:', error);
        this.errorMessage = 'Failed to place order. Please try again.';
        if (error.error?.message) {
          this.errorMessage = error.error.message;
        }
        this.isLoading = false;
      },
    });
  }

  checkOrderStatus(orderId: number) {
    this.pollingInterval = setInterval(() => {
      if (this.currentOrder) {
        console.log(
          'Polled order status (UI simulated):',
          this.currentOrder.orderStatus
        );

        if (this.currentOrder.orderStatus !== 'PENDING') {
          clearInterval(this.pollingInterval);
          this.isLoading = false;

          if (this.currentOrder.orderStatus === 'CONFIRMED') {
            alert('Order placed successfully!');
            this.router.navigate(['/orders'], {
              state: { message: 'Order placed successfully!', orderId: orderId },
            });
          }
        }
      }
    }, 2000);
  }

  cancelCheckout(): void {
    if (this.pollingInterval) {
      clearInterval(this.pollingInterval);
    }
    this.router.navigate(['/cart']);
  }
}
