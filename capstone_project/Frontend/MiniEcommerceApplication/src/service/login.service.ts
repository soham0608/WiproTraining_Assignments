import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../interface/login';
import { map, Observable, switchMap, tap } from 'rxjs';
import { TokenData } from '../interface/token';
import { BASE_URL } from '../util/appConstant';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  login(loginData: any): Observable<any> {
    console.log('Login request:', loginData);
    let url: string = BASE_URL + '/user/login';
    console.log('url-' + url);

    return this.http.post<any>(url, loginData).pipe(
      tap((response) => {
        console.log('Full login response:', response);

        if (response.token) {
          localStorage.setItem('token', response.token);
        }

        if (response.role) {
          localStorage.setItem('role', response.role);
        }
      }),
      switchMap((response) => {
        return this.getAllUsers().pipe(
          tap((users) => {
            const user = users.find((u) => u.userId === loginData.userId);
            if (user && user.id) {
              console.log('Found user:', user);
              localStorage.setItem('user', JSON.stringify(user));
              localStorage.setItem('userId', user.id.toString());
            }
          }),
          map(() => response)
        );
      })
    );
  }

  register(user: Login): Observable<any> {
    let url: string = BASE_URL + '/user';
    console.log('url-' + url);
    return this.http.post<any>(url, user);
  }

  updateUser(id: number, user: any): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', `Bearer ${token}`);

    const url = `${BASE_URL}/user`;
    return this.http.put<any>(url, user, { headers });
  }

  getUserById(id: number): Observable<any> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', `Bearer ${token}`);

    const url = `${BASE_URL}/user/${id}`;
    return this.http.get<any>(url, { headers });
  }

  deleteUser(id: number): Observable<void> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', `Bearer ${token}`);
    const url = `${BASE_URL}/user/${id}`;
    return this.http.delete<void>(url, { headers });
  }

  getAllUsers(): Observable<any[]> {
    const token = localStorage.getItem('token');
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Authorization', `Bearer ${token}`);
    const url = `${BASE_URL}/user`;
    return this.http.get<any[]>(url, { headers });
  }
}
