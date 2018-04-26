import { Component, OnInit } from '@angular/core';
import { User } from '../../entities/user';
import { Router } from '@angular/router';
import { Product } from '../../entities/product';
import { ProductService } from '../../service/productService/product.service';
import { StoreService } from '../../service/storeService/store.service';
import { UserService } from '../../service/userService/user.service';

@Component({
  selector: 'app-collaborator',
  templateUrl: './collaborator.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class CollaboratorComponent implements OnInit {
  private user : User;
  private product : Product;
  private products : Product[];

  constructor(private _userService:UserService ,private _productService:ProductService ,private _storeService:StoreService , private _router:Router) { }

  ngOnInit() {
    this.user = this._userService.getter(); 
    this.product = new  Product();

    this._productService.getStoreProductList(this.user.storename).subscribe((products)=>{
      console.log(products);
      this.products = products;
    },(error)=>{
      console.log(error);
    }
    ) 
  }

  removeProduct(product : Product){
      this._productService.removeProduct(product).subscribe((flag)=>{
        console.log(flag);
        this._storeService.addToHistory(product,"remove",this.user.username,this.user.storename).subscribe((flag2)=>{
            console.log(flag2);
          },(error)=>{
            console.log(error);
          }
          ) ;
        this._router.navigate(["/collaboratorPage"]);
      },(error)=>{
        console.log(error);
      }
      ) ;
  }

  addProduct(){ 
    this._storeService.addToHistory(this.product,"add",this.user.username ,this.user.storename).subscribe((flag)=>{
      console.log(flag);
    },(error)=>{
      console.log(error);
    }
    ) ;
  }

  showStat(type:string){
    this._storeService.setType(type);
    this._router.navigate(["/showStats"]);
    
  }

}
