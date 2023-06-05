import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Role } from '../entities/role';

@Injectable({
  providedIn: 'root',
})
export class RoleService {
  private apiUrl = 'http://localhost:8080/roles/';

  constructor(private http: HttpClient) {}

  getAllRoles(): Observable<Role[]> {
    try {
      return this.http.get<Role[]>(`${this.apiUrl}getAllRoles`);
    } catch {
      return null;
    }
  }
}
