import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Conversation } from '../entities/conversation';
import { User } from '../entities/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ConversationService {
  private apiUrl = 'http://localhost:8080/conversations/';

  constructor(private httpClient: HttpClient) {}

  async createConversation(conversation: Conversation) {
    try {
      const response = await fetch(this.apiUrl + 'createConversation', {
        method: 'PUT',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(conversation),
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

  async findBySenderAndReciever(sender: User, reciever: User) {
    try {
      this.httpClient.get<Conversation>(
        this.apiUrl +
          `findConversationByUserAndReciever?senderId=${sender.id}&receiverId=${reciever.id}`
      );
    } catch (error) {}
  }

  findByUser(user: User): Observable<Conversation[]> {
    try {
      return this.httpClient.get<Conversation[]>(
        `getConversationForUser?id=${user.id}`
      );
    } catch (error) {
      return null;
    }
  }
}
