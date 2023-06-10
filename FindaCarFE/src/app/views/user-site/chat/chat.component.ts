import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/entities/user';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
})
export class ChatComponent implements OnInit {

  users: User[];
  filteredUsers: User[];
  selectedUser: User;
  selectedRole: string;
  roles: string[] = ['Todos', 'Administrador', 'Usuario'];
  user: User;

  constructor(
    private userService: UserService,
    private router: Router,
    private cookieService: CookieService
  ) {}

  ngOnInit(): void {
    // Obtener la lista de usuarios
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    this.user = userData;
    this.userService.getAllUsers().subscribe(
      (resp) => {
        this.users = resp;
      },
      (error) => {
        console.error('Error al obtener la lista de usuarios:', error);
      }
    );
  }

  filterUsersByRole(): void {
    if (this.selectedRole === 'Todos') {
      this.filteredUsers = [];
      this.filteredUsers = this.users;
    } else {
      this.filteredUsers = [];
      this.filteredUsers = this.users.filter(
        (user) => user.rol.name === this.selectedRole
      );
    }
  }

  goToDetailChat(user: User): void {
    // Navegar al componente DetailChatComponent
    this.router.navigate(['userSite/userSite/chat/detailChat', user.id]);
  }
  logOut() {
    this.cookieService.deleteAll();
    this.router.navigate(['/login']);
  }
}
