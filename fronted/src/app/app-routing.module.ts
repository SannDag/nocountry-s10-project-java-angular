import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthModule } from './modules/auth/auth.module';
import { authGuard } from './guards/auth.guard';


const routes: Routes = [

  {
    path:'home',
    loadChildren: () =>import('./modules/home/home.module').then(m => m.HomeModule),
  },
  {
    path:'auth', canActivateChild:[authGuard],
    loadChildren: () =>import('./modules/auth/auth.module').then(m => m.AuthModule),
  },

  {path: '', pathMatch: 'full', redirectTo: 'home'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: false})],
  exports: [RouterModule],
  providers: [RouterModule]
})
export class AppRoutingModule { }
