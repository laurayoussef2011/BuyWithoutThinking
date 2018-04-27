import { Component, OnInit } from '@angular/core';
import { Store } from '../../entities/store';
import { Router } from '@angular/router';
import { StoreService } from '../../service/storeService/store.service';
import { Product } from '../../entities/product';

@Component({
  selector: 'app-show-stat',
  templateUrl: './show-stat.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class ShowStatComponent implements OnInit {
  private type :string;
  private store : Store;
  private products : Product[];

  constructor(private _storeService:StoreService, private _router:Router) { }

  ngOnInit() {
    this.store = this._storeService.getStore();
    this.type = this._storeService.getType();

    this._storeService.getStats(this.store , this.type).subscribe((products)=>{
      console.log(products); 
      this.products = products;
    
    },(error)=>{
      console.log(error);
    })
  }

}
