import { CanActivateFn, Router } from '@angular/router';
import { TokenService } from '../services/token.service';


export const loginGuard: CanActivateFn = (route, state) => {

    const router = new Router();
    const tokenService = new TokenService();

    if(tokenService.isLoggued()){
      router.navigateByUrl("/home");
    }


    return true;
  };







