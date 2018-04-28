import { Component, OnInit } from '@angular/core';
import { User } from '../../entities/user';
import { UserService } from '../../service/userService/user.service';
import { StoreService } from '../../service/storeService/store.service';
import { Router } from '@angular/router';
import { History } from '../../entities/history';

@Component({
  selector: 'app-show-history',
  templateUrl: './show-history.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class ShowHistoryComponent implements OnInit {

  private collaborator : User;
  private history : History[];

  constructor(private _userService:UserService ,private _storeService:StoreService , private _router:Router) { }

  ngOnInit() {
    this.collaborator = this._userService.collaboratorgetter();
    this._storeService.showHistory(this.collaborator.username , this._storeService.getStore().storename).subscribe((history)=>{
      console.log(history);
      this.history = history;
    },(error)=>{
      console.log(error);
    }
    ) 
  }

  undo(h : History){

    this._storeService.undo(h).subscribe((flag)=>{
      console.log(flag);
      if(flag == true)
      {
        window.alert("Undo successful !");
      }
      else
      {
        window.alert("Undo failed !");
      }
      },(error)=>{
      console.log(error);
    }
    ) 
  }

}
