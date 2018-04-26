import { Component, OnInit } from '@angular/core';
import { Store } from '../../entities/store';
import { Router } from '@angular/router';
import { StoreService } from '../../service/storeService/store.service';
import { UserService } from '../../service/userService/user.service';

@Component({
  selector: 'app-add-store',
  templateUrl: './add-store.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class AddStoreComponent implements OnInit {
  private store: Store;
  private flag : boolean;

  constructor(private _userService:UserService,private _storeService:StoreService, private _router:Router) { }

  ngOnInit() {
    this.store = new Store();
    this.flag = false;
  }

  addStore(){

    this.store.storeowner = this._userService.getter().username;
    this._storeService.addStore(this.store).subscribe((flag)=>{
      console.log(flag); 
  
    },(error)=>{
      console.log(error);
    })
  }


}
