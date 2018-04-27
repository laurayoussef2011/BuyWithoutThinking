import { Component, OnInit } from '@angular/core';
import { Product } from '../../entities/product';
import { Router } from '@angular/router';
import { StoreService } from '../../service/storeService/store.service';
import { ProductService } from '../../service/productService/product.service';


@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class AddProductComponent implements OnInit {

  private product :Product;

  constructor(private _storeService:StoreService,private _productService:ProductService, private _router:Router) { }

  ngOnInit() {
    this.product=new Product();
  }

  addProduct(){
    this.product.storename = this._storeService.getStore().storename;
    this._productService.addProduct(this.product).subscribe((flag)=>{
      console.log(flag); 
    
    },(error)=>{
      console.log(error);
    })

  }

}
