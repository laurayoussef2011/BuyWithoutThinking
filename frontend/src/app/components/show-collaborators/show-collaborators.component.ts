import { Component, OnInit } from '@angular/core';
import { User } from '../../entities/user';
import { UserService } from '../../service/userService/user.service';
import { StoreService } from '../../service/storeService/store.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-collaborators',
  templateUrl: './show-collaborators.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class ShowCollaboratorsComponent implements OnInit {
  private collaborators : User[];

  constructor(private _userService:UserService ,private _storeService:StoreService , private _router:Router) { }

  ngOnInit() {
    console.log(this._storeService.getStore().storename);
    this._userService.showCollaborators(this._storeService.getStore().storename).subscribe((flag)=>{
      console.log(flag);
      this.collaborators = flag;
    },(error)=>{
      console.log(error);
    }
    ) 
  }


  showHistory(collaborator : User){
    console.log(collaborator);
    this._userService.collaboratorsetter(collaborator);
    this._router.navigate(["/showHistory"]);
  }

}
