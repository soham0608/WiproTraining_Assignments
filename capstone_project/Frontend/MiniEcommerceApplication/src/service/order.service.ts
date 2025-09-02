import { Injectable } from '@angular/core';
import { BASE_URL } from '../util/appConstant';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../interface/order';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  constructor(private http: HttpClient) {}

  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    if (!token) {
      console.error('No token found in localStorage');
      return new HttpHeaders().set('Content-Type', 'application/json');
    }

    return new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', `Bearer ${token}`);
  }

  createOrder(userId: number): Observable<Order> {
    const url = `${BASE_URL}/order?userId=${userId}`;
    return this.http.post<Order>(url, {}, { headers: this.getHeaders() });
  }

  cancelOrder(orderId: number): Observable<Order> {
    const url = `${BASE_URL}/order/${orderId}/cancel`;
    return this.http.put<Order>(url, {}, { headers: this.getHeaders() });
  }

  getUserOrders(userId: number): Observable<Order[]> {
    const url = `${BASE_URL}/order/user/${userId}`;
    return this.http.get<Order[]>(url, { headers: this.getHeaders() });
  }

  getOrderById(orderId: number): Observable<Order> {
    const url = `${BASE_URL}/order/${orderId}`;
    return this.http.get<Order>(url, { headers: this.getHeaders() });
  }

  getAllOrders(): Observable<Order[]> {
    const url = `${BASE_URL}/order`;
    return this.http.get<Order[]>(url, { headers: this.getHeaders() });
  }

  updateOrderStatus(orderId: number, status: string): Observable<Order> {
    const url = `${BASE_URL}/order/${orderId}/status?status=${status}`;
    return this.http.put<Order>(url, {}, { headers: this.getHeaders() });
  }
}
