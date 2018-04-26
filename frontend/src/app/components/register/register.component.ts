import { Component, OnInit } from '@angular/core';

import { UserService } from '../../service/userService/user.service';
import { Observable } from 'rxjs/Observable';

import {Router} from '@angular/router';
import { User } from '../../entities/user';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class RegisterComponent implements OnInit {
  private user: User;
  
  constructor(private _userservice:UserService , private _router:Router) { }

  ngOnInit() {
    this.user = new User();
  }
  
  register(){

    this._userservice.createUser(this.user).subscribe((user)=>{
      console.log(user); 
      this._router.navigate(["/"]);
    },(error)=>{
      console.log(error);
    })
  
}
 
}

