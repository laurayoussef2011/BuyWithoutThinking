import { Component, OnInit } from '@angular/core';
import { User } from '../../entities/user';
import { Router } from '@angular/router';
import { UserService } from '../../service/userService/user.service';
import { Store } from '../../entities/store';
import { StoreService } from '../../service/storeService/store.service';


@Component({
  selector: 'app-store-owner-page',
  templateUrl: './store-owner-page.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class StoreOwnerPageComponent implements OnInit {
  private user : User;
  private users : User[];
  private stores : Store[];
  private otherStores : Store[];

  constructor(private _userService:UserService ,private _storeService:StoreService , private _router:Router) { }

  ngOnInit() {
    this.user = this._userService.getter();

    this._storeService.getStoreList().subscribe((stores)=>{
      console.log(stores);
      this.otherStores = stores;
    },(error)=>{
      console.log(error);
    }
    )

    this._storeService.getOwnerStoreList(this.user.username).subscribe((stores)=>{
      console.log(stores);
      this.stores = stores;
    },(error)=>{
      console.log(error);
    }
    ) 
  }

  storeProducts(store : Store){
    this._storeService.setStore(store);
    this._router.navigate(["/storeProducts"]);
}

  addProduct(store : Store){
    this._storeService.setStore(store);
    this._router.navigate(["/addProduct"]);
  }

  showStat(store : Store , type:string){
    console.log(type);
    this._storeService.setStore(store );
    this._storeService.setType(type);
    this._router.navigate(["/showStats"]);
  }

  addCollaborator(store : Store){
    this._storeService.setStore(store);
    this._router.navigate(["/addCollaborator"]);
  }

  showCollaborators(store : Store){
    this._storeService.setStore(store);
    this._router.navigate(["/showCollaborators"]);
  }

  logout(){
    this._userService.setter(new User);
    this._userService.setIsUserIsLogged(false);
    this._router.navigate(["/login"]);
  }

}
