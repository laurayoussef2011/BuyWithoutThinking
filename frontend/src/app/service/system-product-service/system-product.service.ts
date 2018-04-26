import { Injectable } from '@angular/core';
import { SystemProduct } from '../../entities/system-product';
import { Http , Response ,Headers, RequestOptions} from '@angular/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SystemProductService {

  private systemProduct : SystemProduct = new SystemProduct ();


  private baseUrl : string = 'http://localhost:8080/systemProductAPI';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({});
  constructor(private _http: Http) { }

  createSystemProduct(systemProduct : SystemProduct  ){
    return this._http.post(this.baseUrl + '/addSystemProduct',systemProduct,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error|| "SERVER ERROR");
  }

  systemProductGetter()
  {
    return this.systemProduct;
  }
  
  systemProductSetter(systemProduct : SystemProduct)
  {
    this.systemProduct = systemProduct;
  }
}
