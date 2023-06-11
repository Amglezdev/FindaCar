import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../entities/post';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  private apiUrl = 'http://localhost:8080/post/';

  constructor(private http: HttpClient) {}

  getAllPosts(): Observable<Post[]> {
    try {
      return this.http.get<Post[]>(`${this.apiUrl}findAll`);
    } catch {
      return null;
    }
  }

  async createPost(post: Post) {
    try {
      const response = await fetch(this.apiUrl + 'addPost', {
        method: 'PUT',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(post),
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

  async deletePost(id: number) {
    try {
      return this.http.delete(`${this.apiUrl}deletePost?id=${id}`);
    } catch (error) {
      return null;
    }
  }

  async updatePost(post: Post) {
    try {
      const response = await fetch(this.apiUrl + 'updatePost', {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
          'Content-Type': 'application/json',
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(post),
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
 findById(id: number) :Observable<Post> {
    try {
      return this.http.get<Post>(`${this.apiUrl}findById?id=${id}`);
    } catch (error) {
      return null;
    }
  }

}
