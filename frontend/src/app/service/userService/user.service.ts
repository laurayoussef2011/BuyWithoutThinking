import { Injectable } from '@angular/core';
import {Http , Response ,Headers, RequestOptions} from '@angular/http';
import { Type } from '@angular/compiler/src/output/output_ast';
import { Observable } from 'rxjs/Observable';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { User } from '../../entities/user';


@Injectable()
export class UserService {
  private isUserIsLogged: boolean;
  private user : User = new User ();
  private collaborator : User = new User ();
  private baseUrl : string = 'http://localhost:8080/userAPI';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({});
  constructor(private _http: Http) {
    this.isUserIsLogged=false;
   }

  getUsers(){
    return this._http.get(this.baseUrl + '/users' , this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  getUser(username : string){
    return this._http.get(this.baseUrl + '/user/' + username , this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  deleteUsers(){
    return this._http.delete(this.baseUrl + '/deleteUsers' , this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }
  deleteUser(username : string){
    return this._http.delete(this.baseUrl + '/deleteUser/'+ username , this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  createUser(user :User  ){
    return this._http.post(this.baseUrl + '/createUser',user,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  login(user :User  ){
    return this._http.post(this.baseUrl + '/login',user,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  showCollaborators(storeName : string){
    return this._http.post(this.baseUrl + '/showCollaborators/' + storeName,  this.options).map((response:Response)=>response.json()).catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error|| "SERVER ERROR");
  }

  getter()
  {
    return this.user;
  }
  
  setter(user : User )
  {
    this.user =user;
  }

  collaboratorgetter()
  {
    return this.collaborator;
  }
  
  collaboratorsetter(collaborator : User )
  {
    this.collaborator =collaborator;
  }
  
  setIsUserIsLogged(flag:boolean){
    this.isUserIsLogged = flag;
  }
  getIsUserIsLogged(){
    return this.isUserIsLogged;
  }
}
