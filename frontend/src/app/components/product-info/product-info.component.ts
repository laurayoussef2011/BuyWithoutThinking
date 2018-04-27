import { Component, OnInit } from '@angular/core';
import { Product } from '../../entities/product';
import { Router } from '@angular/router';
import { ProductService } from '../../service/productService/product.service';

@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class ProductInfoComponent implements OnInit {

  private product :Product;

  constructor( private _productService : ProductService , private _router:Router) { }

  ngOnInit() {

      this.product = this._productService.productGetter();
  }

  buyProduct(){
    this._productService.productSetter(this.product);
    this._router.navigate(["/buyProduct"]);
  
  }

}
