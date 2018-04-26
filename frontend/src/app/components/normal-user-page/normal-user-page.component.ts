import { Component, OnInit } from '@angular/core';
import { User } from '../../entities/user';
import { Router } from '@angular/router';
import { Product } from '../../entities/product';
import { Store } from '../../entities/store';
import { ProductService } from '../../service/productService/product.service';
import { StoreService } from '../../service/storeService/store.service';
import { UserService } from '../../service/userService/user.service';

@Component({
  selector: 'app-normal-user-page',
  templateUrl: './normal-user-page.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class NormalUserPageComponent implements OnInit {
  private user : User;
  private products : Product[];
  private stores : Store[];
  constructor(private _userService:UserService,private _productService:ProductService,private _storeService:StoreService, private _router:Router) { }

  ngOnInit() {
    this.user = this._userService.getter();

    this._productService.getProductList().subscribe((products)=>{
      console.log(products);
      this.products = products;
    },(error)=>{
      console.log(error);
    }
    ) 

    this._storeService.getStoreList().subscribe((stores)=>{
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

  logout(){
    this._userService.setter(new User);
    this._userService.setIsUserIsLogged(false);
    this._router.navigate(["/login"]);
  }


}
