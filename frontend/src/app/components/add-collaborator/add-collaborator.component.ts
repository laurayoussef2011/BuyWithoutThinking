import { Component, OnInit } from '@angular/core';
import { User } from '../../entities/user';
import { UserService } from '../../service/userService/user.service';
import { StoreService } from '../../service/storeService/store.service';
import { Router } from '@angular/router';
import { CollaboratorComponent } from '../collaborator/collaborator.component';

@Component({
  selector: 'app-add-collaborator',
  templateUrl: './add-collaborator.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class AddCollaboratorComponent implements OnInit {

  private user : User;
  private collaborator: User;
  constructor(private _userService:UserService ,private _storeService:StoreService , private _router:Router) { 
    this.user = new User();
    this.collaborator = new User ();
  }

  ngOnInit() {
    this.user = this._userService.getter();
  }

  addCollaborator(){
    this.collaborator.type = "collaborator";
    this.collaborator.storename = this._storeService.getStore().storename;


    this._userService.createUser(this.collaborator).subscribe((flag)=>{
      console.log(flag); 
      if(flag == true)
      {
        window.alert("Add collaborator successfully !");
      }
      else
      {
        window.alert(" Collaborator userName allready exist OR There is missing information  !");
      }
    },(error)=>{
      console.log(error);
    })
  
  }

}
