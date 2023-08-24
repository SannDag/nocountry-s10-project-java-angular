import { CanActivateFn, Router } from '@angular/router';
import { TokenService } from '../services/token.service';

export const loginGuard: CanActivateFn = (route, state) => {

    return true;
  };







