import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePage } from './pages/home-page/home.page';
import { GeneralDataComponent } from './pages/general-data/general-data.component';
import { GeneralMaterialComponent } from './pages/general-material/general-material.component';
import { CalculadoraComponent } from './pages/calculadora/calculadora.component';
import { GaranteComponent } from './pages/garante/garante.component';




const routes: Routes = [
  {
  path:'',
    children:[

    {path: '', component: HomePage},
    {path:'general', component: GeneralDataComponent},
    {path:'generalM', component:GeneralMaterialComponent},
    {path: '',component:HomePage},
    {path: 'calculadora',component:CalculadoraComponent},
    {path: 'garante', component:GaranteComponent}

  ]
  }

]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
