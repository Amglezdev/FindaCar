import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehicle } from '../entities/vehicle';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  private apiUrl = 'http://localhost:8080/vehicles/';

  constructor(private http:HttpClient) { }

  async createVehicle(vehicle:Vehicle) {
    try {
      const response = await fetch(this.apiUrl + 'addVehicle', {
        method: 'PUT',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(vehicle),
      });
      console.log(vehicle);
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

  getUserById(id: number): Observable<Vehicle> {
    try {
      return this.http.get<Vehicle>(`${this.apiUrl}findById?id=${id}`);
    } catch {
      return null;
    }
  }

  async updateVehicle(vehicle:Vehicle) {
    try {
      const response = await fetch(this.apiUrl + 'addVehicle', {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(vehicle),
      });
      console.log(vehicle);
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

  getByUserId(id: number): Observable<Vehicle[]> {
    try {
      return this.http.get<Vehicle[]>(`${this.apiUrl}findByOwnerId?id=${id}`);
    } catch {
      return null;
    }
  }

}
