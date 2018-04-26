import { Injectable } from '@angular/core';
import {Http , Response ,Headers, RequestOptions} from '@angular/http';
import { Type } from '@angular/compiler/src/output/output_ast';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Product } from '../../entities/product';
import { User } from '../../entities/user';


@Injectable()
export class ProductService {

  private product : Product = new Product ();

  private baseUrl : string = 'http://localhost:8080/productAPI';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({});
  constructor(private _http: Http) { }

  addProduct(product :Product  ){
    return this._http.post(this.baseUrl + '/addProduct',product,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  getProductList( ){
    return this._http.get(this.baseUrl + '/getProductList',  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }


  removeProduct( product : Product){
    return this._http.post(this.baseUrl + '/removeProduct', product,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  getStoreProductList( storeName : string){
    return this._http.post(this.baseUrl + '/getProductList/'+ storeName,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  buyProduct( serialNumber : number,address : string , quantity :number , user : User){
    return this._http.post(this.baseUrl + '/buyProduct/' + serialNumber +'/' + address +'/' +quantity , user ,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  incrementView( product : Product){
    return this._http.post(this.baseUrl + '/incrementView', product,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error|| "SERVER ERROR");
  }



  productGetter(){
    return this.product;
  }

  productSetter(_product : Product){
    this.product = _product;
  }

}
