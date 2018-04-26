import { Component, OnInit } from '@angular/core';
import { SystemProduct } from '../../entities/system-product';

import { Router } from '@angular/router';
import { Brand } from '../../entities/brand';
import { User } from '../../entities/user';
import { UserService } from '../../service/userService/user.service';

@Component({
  selector: 'app-admin-page',
  templateUrl: './admin-page.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class AdminPageComponent implements OnInit {
  private user : User;
  private brand : Brand;
  private systemProduct : SystemProduct;

  constructor( private _userService:UserService ,private _router:Router) { }

  ngOnInit() {
    this.brand = new Brand();
    this.systemProduct = new SystemProduct();
  }


  logout(){
    this._userService.setter(new User());
    this._userService.setIsUserIsLogged(false);
    this._router.navigate(["/login"]);
  }

}
