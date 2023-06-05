import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { VehicleType } from '../entities/vehicle-type';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleTypesService {
  private apiUrl = 'http://localhost:8080/vehicleType/';

  constructor(private http:HttpClient) { }

  getAllTypes(): Observable<VehicleType[]> {
    try {
      return this.http.get<VehicleType[]>(`${this.apiUrl}allTypes`);
    } catch {
      return null;
    }
  }

  async createType(vehicleType:VehicleType) {
    try {
      console.log(vehicleType.name)
      const response = await fetch(this.apiUrl + 'addType', {
        method: 'PUT',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(vehicleType),
      });
      console.log(vehicleType);
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
