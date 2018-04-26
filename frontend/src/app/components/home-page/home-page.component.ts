import { Component, OnInit } from '@angular/core';

import { UserService } from '../../service/userService/user.service';
import {Router} from '@angular/router';
import { User } from '../../entities/user';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  private user : User;
  private users : User[];
  
  constructor(private _userservice:UserService , private _router:Router) { } // dependancies

  ngOnInit() {
    this._userservice.getUsers().subscribe((users)=>{
      console.log(users);
      this.users = users;
    },(error)=>{
      console.log(error);
    }
    ) 
  }

  deleteUser(user , username: string)  {

    this._userservice.deleteUser(username).subscribe((data)=>{
      this.users.splice(this.users.indexOf(user),1);
    
    },(error)=>{
      console.log(error);
    }) 
  }

  updateUser(user , username: string)  {

    this._userservice.setter(user);
    this._router.navigate(['/register']);
  }

  register(){
    let user = new User();
    this._userservice.setter(user);
    this._router.navigate(['/register']);
  }

  login(){
    let user = new User();
    this._userservice.setter(user);
    this._router.navigate(['/login']);

  }
  

}
