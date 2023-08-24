import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{

  isLoggedIn: boolean = false;

  constructor(private tokenService:TokenService, private router:Router){}

  ngOnInit(): void {}

  isLoggedInUser():boolean{
    return this.tokenService.isLoggued();
  }

  SignOff(){
    this.tokenService.logOut();
    this.router.navigateByUrl("/auth/login");
  }

}
