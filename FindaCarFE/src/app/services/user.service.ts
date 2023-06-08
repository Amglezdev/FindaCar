import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { User } from 'src/app/entities/user';
import * as $ from 'jquery';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private apiUrl = 'http://localhost:8080/users/';
  dataType = 'json';
  $: any;
  user: User;
  constructor(private http: HttpClient) {}

  getUserById(id: number): Observable<User> {
    try {
      return this.http.get<User>(`${this.apiUrl}getById?id=${id}`);
    } catch {
      return null;
    }
  }

  getAllUsers(): Observable<User[]> {
    try {
      return this.http.get<User[]>(`${this.apiUrl}getUsers`);
    } catch (error) {
      return null;
    }
  }

  async deleteUser(id: number) {
    try {
      return this.http.delete(`${this.apiUrl}deleteUser?id=${id}`);
    } catch (error) {
      return null;
    }
  }

  async getUserByMailAndPassword(user: User) {
    try {
      return await fetch(this.apiUrl + 'getByMailAndPassword', {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
          'Content-Type': 'application/json',
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        body: JSON.stringify(user), // body data type must match "Content-Type" header
      });
    } catch (error) {
      return null;
    }

  }

  async updateUser(user: User) {
    try {
      return await fetch(this.apiUrl + 'updateUser', {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
          'Content-Type': 'application/json',
          // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
        body: JSON.stringify(user), // body data type must match "Content-Type" header
      });
    } catch (error) {
      return null;
    }

  }

  async createUser(user: User) {
    try {
      const response = await fetch(this.apiUrl + 'addUser', {
        method: 'PUT',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(user),
      });
      console.log(user);
      if (response.ok) {
        // Registro exitoso
        return true;
      } else {
        // Error al realizar el registro
        return false;
      }
    } catch (error) {
      // Error en la solicitud
      return false;
    }
  }
}
