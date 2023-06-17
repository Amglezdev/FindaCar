import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Favorites } from '../entities/favorites';

@Injectable({
  providedIn: 'root',
})
export class FavoritesService {
  private apiUrl = 'http://localhost:8080/userFavorites/';

  constructor(private http: HttpClient) {}

   getUserById(id: number): Observable<Favorites[]> {
    try {
      return this.http.get<Favorites[]>(`${this.apiUrl}getByUserId?id=${id}`);
    } catch {
      return null;
    }
  }

  async addFavorites(favorites: Favorites) {
    try {
      const response = await fetch(this.apiUrl + 'addFavorites', {
        method: 'PUT',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(favorites),
      });
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

  async deleteFromFavorites(favorite:Favorites) {
    try {
      const response = await fetch(this.apiUrl + 'deleteFromFavorites', {
        method: 'DELETE',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(favorite),
      });
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
  findById(id: number): Observable<Favorites> {
    try {
      return this.http.get<Favorites>(`${this.apiUrl}findById?id=${id}`);
    } catch {
      return null;
    }
  }


}
