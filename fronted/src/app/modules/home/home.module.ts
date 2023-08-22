import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomePage } from './pages/home-page/home.page';
import { MatIconModule } from '@angular/material/icon';


@NgModule({
  declarations: [
    HomePage
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,


    MatIconModule,
  ]
})
export class HomeModule { }
