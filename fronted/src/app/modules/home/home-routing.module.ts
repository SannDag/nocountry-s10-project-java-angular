import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePage } from './pages/home-page/home.page';
import { GeneralDataComponent } from './pages/general-data/general-data.component';
import { GeneralMaterialComponent } from './pages/general-material/general-material.component';




const routes: Routes = [
  {
  path:'',
    children:[

    {path: '', component: HomePage},
    {path:'general', component: GeneralDataComponent},
    {path:'generalM', component:GeneralMaterialComponent},

  ]
  }

]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
