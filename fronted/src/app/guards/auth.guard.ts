import { CanActivateFn, Router } from '@angular/router';
import { TokenService } from '../services/token.service';
import { AuthService } from '../services/auth.service';
/*
export const authGuard: CanActivateFn = (route, state) => {
  const router = new Router();

  const tokenStore = new TokenService();

  if(tokenStore.isLoggued()){
    alert("Ruta bloqueada");
    router.navigate(['']);
    return  false;

     // No permitir el acceso a la página de registro
  }
 return true;

};
*/
