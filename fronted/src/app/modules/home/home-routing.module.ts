import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePage } from './pages/home-page/home.page';
import { GeneralDataComponent } from './pages/general-data/general-data.component';
import { GeneralMaterialComponent } from './pages/general-material/general-material.component';
import { CalculadoraComponent } from './pages/calculadora/calculadora.component';
import { GaranteComponent } from './pages/garante/garante.component';
import { InformaLaboralComponent } from './pages/informa-laboral/informa-laboral.component';




const routes: Routes = [
  {
  path:'',
    children:[

    {path: '', component: HomePage},
    {path:'generalP', component: GeneralDataComponent},
    {path:'general', component:GeneralMaterialComponent},
    {path: '',component:HomePage},
    {path: 'calculadora',component:CalculadoraComponent},
    {path: 'garante', component:GaranteComponent},
    {path: 'informeLa',component:InformaLaboralComponent},

  ]
  }

]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
