import { CanActivateFn } from '@angular/router';
import { Location } from '@angular/common';
import { user} from 'src/environments/environments';



export const adminGuardGuard:
CanActivateFn = (route, state) => {
    console.log('Guard'+user.rol.name)
  if(user.rol.name === 'Administrador'){
    return true;
  }else{
    return false;
  }
};
