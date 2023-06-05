import { CanActivateFn } from '@angular/router';
import { user } from 'src/environments/environments';

export const userSiteGuard: CanActivateFn = (route, state) => {


  switch (user.rol.name) {
    case 'Administrador':
    return true;
      break;
    case 'Usuario':
      return true;
    case '':
      return false;
    case null:
      return true;
    default:
      return false;
      break;
  }
};
