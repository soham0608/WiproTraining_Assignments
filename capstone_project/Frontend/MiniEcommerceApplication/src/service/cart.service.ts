import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { BASE_URL } from '../util/appConstant';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  constructor(private http: HttpClient) {}

  addToCart(
    userId: number,
    productId: number,
    quantity: number
  ): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });

    console.log(
      `Adding to cart: userId=${userId}, productId=${productId}, quantity=${quantity}`
    );
    console.log(
      `API URL: ${BASE_URL}/cart/addProd?userId=${userId}&productId=${productId}&quantity=${quantity}`
    );

    return this.http.post(
      `${BASE_URL}/cart/addProd?userId=${userId}&productId=${productId}&quantity=${quantity}`,
      {},
      { headers }
    );
  }

  getCart(userId: number): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });

    console.log(`Getting cart for userId=${userId}`);

    return this.http.get(`${BASE_URL}/cart/${userId}`, { headers });
  }

  updateCartItem(
    userId: number,
    productId: number,
    quantity: number
  ): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });

    return this.http.put(
      `${BASE_URL}/cart/update?userId=${userId}&productId=${productId}&quantity=${quantity}`,
      {},
      { headers }
    );
  }

  removeFromCart(userId: number, productId: number): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });

    return this.http.delete(
      `${BASE_URL}/cart/deleteProd/${userId}/${productId}`,
      { headers }
    );
  }
}
