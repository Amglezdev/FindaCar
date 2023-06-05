import { CanActivateFn } from '@angular/router';
import { user } from 'src/environments/environments';

export const authGuard: CanActivateFn = (route, state) => {

  switch (user.rol.name) {
    case 'Administrador':
    return false;
      break;
    case 'Usuario':
      return false;
    case '':
      return true;
    case null:
      return true;
    default:
      return false;
      break;
  }
};
