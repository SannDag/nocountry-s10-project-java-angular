import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePage } from './pages/home-page/home.page';
import { GeneralMaterialComponent } from './pages/general-material/general-material.component';
import { CalculadoraComponent } from './pages/calculadora/calculadora.component';
import { GaranteComponent } from './pages/garante/garante.component';
import { InformaLaboralComponent } from './pages/informa-laboral/informa-laboral.component';
import { ConfirmationComponent } from './pages/confirmation/confirmation.component';




const routes: Routes = [
  {
  path:'',
    children:[

    {path: '', component: HomePage},
    {path: 'general', component: GeneralMaterialComponent},
    {path: 'calculadora', component: CalculadoraComponent},
    {path: 'garante', component: GaranteComponent},
    {path: 'informeLa', component: InformaLaboralComponent},
    {path: 'confirm', component: ConfirmationComponent}

  ]
  }

]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
