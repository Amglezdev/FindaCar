import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Favorites } from '../entities/favorites';
import { Message } from '../entities/message';
import { Conversation } from '../entities/conversation';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  private apiUrl = 'http://localhost:8080/messages/';

  constructor(private http: HttpClient) {}


  async sendMessage(message: Message) {
    try {
      const response = await fetch(this.apiUrl + 'sendMessage', {
        method: 'PUT',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(message),
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

  findByConversationId(id:number):Observable<Message[]>{
    try {
      return this.http.get<Message[]>(`${this.apiUrl}getMessages?id=${id}`)
    } catch (error) {
      return null;
    }
  }

}
