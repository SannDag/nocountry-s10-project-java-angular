import { CanActivateFn, Router } from '@angular/router';
import { TokenService } from '../services/token.service';

export const authGuard: CanActivateFn = (route, state) => {
  const router = new Router();
  const tokenStore = new TokenService();

  if(tokenStore.isLoggued()){
    alert('Ya estás logueado. No puedes acceder a la página de registro.');
    router.navigateByUrl("");

    return false;
     // No permitir el acceso a la página de registro
  }
 return true;
};
