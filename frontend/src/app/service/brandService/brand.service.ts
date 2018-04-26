import { Injectable } from '@angular/core';
import {Http , Response ,Headers, RequestOptions} from '@angular/http';
import { Type } from '@angular/compiler/src/output/output_ast';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Brand } from '../../entities/brand';

@Injectable()
export class BrandService {
  private brand : Brand = new Brand();
  
  private baseUrl : string = 'http://localhost:8080/brandAPI';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({});
  constructor(private _http: Http) { }

  createBrand(brand : Brand){
    return this._http.post(this.baseUrl + '/addBrand', brand, this.options).map((response : Response)=>response.json()).catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error|| "SERVER ERROR");
  }

  brandGetter()
  {
    return this.brand;
  }
  
  brandSetter(brand : Brand)
  {
    this.brand = brand;
  }
}