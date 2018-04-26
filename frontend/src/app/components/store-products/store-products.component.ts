import { Component, OnInit } from '@angular/core';
import { Product } from '../../entities/product';
import { StoreService } from '../../service/storeService/store.service';
import { Router } from '@angular/router';
import { UserService } from '../../service/userService/user.service';
import { ProductService } from '../../service/productService/product.service';


@Component({
  selector: 'app-store-products',
  templateUrl: './store-products.component.html',
  styleUrls:  ['././../home-page/home-page.component.css']
})
export class StoreProductsComponent implements OnInit {
  private products : Product[];

  constructor(private _productService : ProductService ,private _storeService:StoreService, private _userService:UserService, private _router:Router) { }

  ngOnInit() {
    this._productService.getStoreProductList(this._storeService.getStore().storename).subscribe((products)=>{
      console.log(products);
      this.products = products;
    },(error)=>{
      console.log(error);
    }
    ) 
  }
  
  getProductInfo(product : Product){
    this._productService.productSetter(product);
    this._productService.incrementView(product).subscribe((flag)=>{
      console.log(flag);
    },(error)=>{
      console.log(error);
    }
    ) ;
    this._router.navigate(["/productInfo"]);
  }

  buyProduct(product: Product){
    this._productService.productSetter(product);
    this._router.navigate(["/buyProduct"]);
  
  }

  back(){
    this._router.navigate(["/" + this._userService.getter().type + "Page"]);
  }

}
