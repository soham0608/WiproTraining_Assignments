import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Order } from '../../interface/order';
import { OrderItem } from '../../interface/orderItem';
import { OrderService } from '../../service/order.service';
import { ProductService } from '../../service/product.service';
import { Router } from '@angular/router';
import { HeaderComponent } from '../header/header.component';

@Component({
  selector: 'app-orderhistory',
  imports: [CommonModule, HeaderComponent],
  templateUrl: './orderhistory.component.html',
  styleUrl: './orderhistory.component.css',
})
export class OrderhistoryComponent {
  orders: Order[] = [];
  orderItems: { [orderId: number]: OrderItem[] } = {};
  userId: number = 0;
  isLoading: boolean = false;
  errorMessage: string = '';
  successMessage: string = '';

  constructor(
    private orderService: OrderService,
    private productService: ProductService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const navigation = this.router.getCurrentNavigation();
    if (navigation?.extras?.state) {
      this.successMessage = navigation.extras.state['message'] || '';

      this.router.navigate([], {
        replaceUrl: true,
        state: undefined,
      });
    }

    this.loadUserId();
    this.loadOrders();
  }

  loadUserId(): void {
    const storedUserId = localStorage.getItem('userId');
    if (storedUserId) {
      this.userId = parseInt(storedUserId, 10);
    }
  }

  loadOrders(): void {
    if (this.userId === 0) {
      this.errorMessage = 'Please log in to view orders';
      return;
    }

    this.isLoading = true;
    this.orderService.getUserOrders(this.userId).subscribe({
      next: (orders) => {
        this.orders = orders;
        this.processOrderItems();
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Error loading orders:', error);
        this.errorMessage = 'Failed to load orders. Please try again.';
        this.isLoading = false;
      },
    });
  }

  processOrderItems(): void {
    this.orders.forEach((order) => {
      if (order.orderId) {
        this.orderItems[order.orderId] = [];

        Object.entries(order.productQuantityMap).forEach(
          ([productId, quantity]) => {
            const pid = parseInt(productId);

            this.productService.getProductById(pid).subscribe({
              next: (product) => {
                const item: OrderItem = {
                  productId: pid,
                  productName: product.prodName,
                  quantity: quantity,
                  price: product.price,
                  total: product.price * quantity,
                };

                this.orderItems[order.orderId!].push(item);
              },
              error: (error) => {
                console.error('Error loading product:', error);
                const item: OrderItem = {
                  productId: pid,
                  productName: `Product ${pid}`,
                  quantity: quantity,
                  price: 0,
                  total: 0,
                };
                this.orderItems[order.orderId!].push(item);
              },
            });
          }
        );
      }
    });
  }

  cancelOrder(orderId: number): void {
    if (confirm('Are you sure you want to cancel this order?')) {
      this.orderService.cancelOrder(orderId).subscribe({
        next: (order) => {
          alert('Order cancelled successfully');
          this.loadOrders(); // Reload orders to refresh status
        },
        error: (error) => {
          console.error('Error cancelling order:', error);
          alert('Failed to cancel order. Please try again.');
        },
      });
    }
  }

  canCancelOrder(order: Order): boolean {
    return order.orderStatus === 'CONFIRMED';
  }

  getOrderItems(orderId: number): OrderItem[] {
    return this.orderItems[orderId] || [];
  }

  getOrderTotal(order: Order): number {
    const items = this.getOrderItems(order.orderId!);
    return items.reduce((total, item) => total + item.total, 0);
  }

  continueShopping(): void {
    this.router.navigate(['/products']);
  }
}
