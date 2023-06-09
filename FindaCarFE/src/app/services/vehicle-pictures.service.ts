import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { VehiclePictures } from '../entities/vehicle-pictures';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehiclePicturesService {

  private apiUrl = 'http://localhost:8080/pictures/';

  constructor(private http:HttpClient) { }

  getByVehicleId(id: number): Observable<VehiclePictures[]> {
    try {
      return this.http.get<VehiclePictures[]>(`${this.apiUrl}findAllById?id=${id}`);
    } catch {
      return null;
    }
  }

  async addPicture(vehiclePicture:VehiclePictures) {
    try {
      const response = await fetch(this.apiUrl + 'addPicture', {
        method: 'PUT',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(vehiclePicture),
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
  deleteById(id: number){
    try {
      return this.http.delete(`${this.apiUrl}deletePicture?id=${id}`);
    } catch {
      return null;
    }
  }

}



