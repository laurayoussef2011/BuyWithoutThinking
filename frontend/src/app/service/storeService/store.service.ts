import { Injectable } from '@angular/core';
import {Http , Response ,Headers, RequestOptions} from '@angular/http';
import { Type } from '@angular/compiler/src/output/output_ast';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Store } from '../../entities/store';
import { Product } from '../../entities/product';
import { History } from '../../entities/history';


@Injectable()
export class StoreService {
  private type :string;
  private store : Store = new Store ();
  
  private baseUrl : string = 'http://localhost:8080/storeAPI';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({});
  constructor(private _http: Http) { }

  addStore(store :Store  ){
    return this._http.post(this.baseUrl + '/addStore',store,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  getStoreList( ){
    return this._http.get(this.baseUrl + '/getStoreList',  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  getStats(store : Store, type :string){
    return this._http.post(this.baseUrl + '/showStat/'+ type, store,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  addToHistory(product: Product ,type : string , username :string, storeName : string){
    return this._http.post(this.baseUrl + '/addToHistory/'+ username + '/' + type + '/' + storeName ,product,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);

  }
  showHistory( username :string, storeName : string){
    return this._http.post(this.baseUrl + '/showHistory/'+ username + '/'  + storeName ,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  showMethods(){
    return this._http.post(this.baseUrl + '/showMethods',  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  getOwnerStoreList(storeOwnerName : string){
    return this._http.post(this.baseUrl + '/getOwnerStoreList/' + storeOwnerName,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  undo( history : History){
    console.log(history);
    return this._http.post(this.baseUrl + '/undo', history,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error|| "SERVER ERROR");
  }

  setStore(store : Store){
    this.store = store;
}

getStore(){
  return this.store;
}


setType(type : string){
  this.type = type;
}

getType(){
  return this.type;
}
}