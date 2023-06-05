import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Fuel } from '../entities/fuel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FuelService{
  private apiUrl = 'http://localhost:8080/fuels/';

  constructor(private http:HttpClient) { }

  getAllTypes(): Observable<Fuel[]> {
    try {
      return this.http.get<Fuel[]>(`${this.apiUrl}getAll`);
    } catch {
      return null;
    }
  }

  async createFuel(fuel:Fuel) {
    try {
      console.log(fuel.name)
      const response = await fetch(this.apiUrl + 'addFuel', {
        method: 'PUT',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(fuel),
      });
      console.log(fuel);
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
