import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePage } from './pages/home-page/home.page';
import { CalculadoraComponent } from './pages/calculadora/calculadora.component';




const routes: Routes = [
  {
  path:'',
    children:[

    {path: '',component:HomePage},
    {path: 'calculadora',component:CalculadoraComponent},

  ]
  }

]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
