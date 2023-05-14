import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../entities/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  //Url towards auth controller in our api
  private url = 'http://localhost:8080/users';

  constructor(private http:HttpClient) { }

  login(username:string, password:string){
    return this.http.post<any>(`${this.url}/login`, {username,password});
  }

  register(user:User){
    return this.http.post<any>(`${this.url}/register`,user);
  }
}
