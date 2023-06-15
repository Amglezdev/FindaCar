import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class UserSiteGuard implements CanActivate {
  constructor(private cookieService: CookieService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    if (userData && userData.rol && userData.rol.name) {
      switch (userData.rol.name) {
        case 'Administrador':
        case'SuperAdministrador':
        case 'Usuario':
          return true; // Permite el acceso para los roles de Administrador y Usuario
        default:
          this.router.navigate(['/login']); // Redirige a la página de login para otros roles
          return false;
      }
    } else {
      this.router.navigate(['/login']); // Redirige a la página de login si no se encuentra información de usuario
      return false;
    }
  }
}
