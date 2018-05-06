import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../../service/productService/product.service';
import { UserService } from '../../service/userService/user.service';

@Component({
  selector: 'app-buy-product',
  templateUrl: './buy-product.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class BuyProductComponent implements OnInit {

  constructor(private _productService : ProductService, private _userService:UserService, private _router:Router) { }

  ngOnInit() {
    
  }

  buyProduct( address : string , quantity :  number){

    this._productService.buyProduct(this._productService.productGetter().serialnumber
    , address , quantity , this._userService.getter()).subscribe((flag)=>{
      console.log(flag);
      if(flag == true)
      {
        window.alert("Transaction successful !");
        if(this._userService.getter().type == "storeOwner")
        {
          window.alert("transactions decreased 15% :D !");
        }
        else if (quantity >= 2 )
        {
          window.alert("transactions decreased 10% :D !");
        }
      }
      else
      {
        window.alert("Transaction failed !");
      }
    },(error)=>{
      console.log(error);
    }
    ) ;
  }


}
