import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the UsernamelogProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class UsernamelogProvider {
  username: string =" ";
  constructor(public http: HttpClient) {
    console.log('Hello UsernamelogProvider Provider');
  }
  setUsername(nombre){
  	this.username = nombre;
  	console.log(this.username);
  }
  getUsername(){
  	return this.username;
  }

}
