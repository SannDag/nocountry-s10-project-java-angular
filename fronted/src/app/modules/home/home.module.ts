import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomePage } from './pages/home-page/home.page';
import { NavbarComponent } from './pages/navbar/navbar.component';
import { MatIconModule } from '@angular/material/icon';
import { FooterComponent } from './pages/footer/footer.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from 'src/app/interceptors/token.interceptor';
import { CalculadoraComponent } from './pages/calculadora/calculadora.component';
import {MatSliderModule} from '@angular/material/slider';





@NgModule({
  declarations: [
    HomePage,
    NavbarComponent,
    FooterComponent,
    CalculadoraComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
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
