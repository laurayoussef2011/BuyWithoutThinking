import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { User } from '../../entities/user';
import { UserService } from '../../service/userService/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class LoginComponent implements OnInit {
  private user: User;
  constructor(private _userservice: UserService , private _router : Router) { }

  ngOnInit() {
    this.user = new User();

  }

  login(){

    this._userservice.login(this.user).subscribe((flag)=>{
      console.log(flag);
      if(flag.name != ""){

        this._userservice.setter(flag);
        this._userservice.setIsUserIsLogged(true);
        this._router.navigate(["/" + this.user.type + "Page" ]);
      }
      else{
        
        this._router.navigate(["/login"]);
      }
    },
    (error)=>{
      console.log(error);
    }) 

  }
  

}
