import { Component, OnInit } from '@angular/core';
import { SystemProduct } from '../../entities/system-product';
import { SystemProductService} from '../../service/system-product-service/system-product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-system-product',
  templateUrl: './add-system-product.component.html',
  styleUrls:['././../home-page/home-page.component.css']
})
export class AddSystemProductComponent implements OnInit {
  private systemProduct : SystemProduct;

  constructor( private _systemProductService:SystemProductService ,private _router:Router) { }
  

  ngOnInit() {
    this.systemProduct = new SystemProduct();

  }

  addSystemProduct(){
    this._systemProductService.createSystemProduct(this.systemProduct).subscribe((flag)=>{
      console.log(flag); 
    },(error)=>{
      console.log(error);
    })
  }

}
