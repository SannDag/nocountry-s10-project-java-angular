import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomePage } from './pages/home-page/home.page';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { MatIconModule } from '@angular/material/icon';
import { FooterComponent } from './pages/footer/footer.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from 'src/app/interceptors/token.interceptor';
import { GeneralDataComponent } from './pages/general-data/general-data.component';
import { ReactiveFormsModule } from '@angular/forms';
import { GeneralMaterialComponent } from './pages/general-material/general-material.component';

import { CalculadoraComponent } from './pages/calculadora/calculadora.component';
import {MatSliderModule} from '@angular/material/slider';
import { InformaLaboralComponent } from './pages/informa-laboral/informa-laboral.component';





@NgModule({
  declarations: [
    HomePage,
    NavbarComponent,
    FooterComponent,
    GeneralDataComponent,
    GeneralMaterialComponent,
    CalculadoraComponent,
    InformaLaboralComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    MatIconModule,
    ReactiveFormsModule,
    MatIconModule,
    MatSliderModule

  ],
  exports:[
    NavbarComponent,
    FooterComponent
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi:true}
  ],
})
export class HomeModule { }
