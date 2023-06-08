import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AdminSiteGuard implements CanActivate {
  constructor(private cookieService: CookieService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const userDataString = this.cookieService.get('userData');
    const userData = JSON.parse(userDataString);
    if (userData && userData.rol && userData.rol.name && userData.rol.name === 'Administrador') {
      return true; // Permite el acceso solo si el rol es 'Administrador'
    } else {
      this.router.navigate(['/login']); // Redirige a la página de login para otros roles o si no se encuentra información de usuario
      return false;
    }
  }
}
