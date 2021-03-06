import {Http} from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

/*
  Generated class for the HttpProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class HttpProvider {
  datos: any;
  path : string = 'http://localhost:9080/PacketTecServer/rest/register';
  constructor(public http:Http, public http1:HttpClient) {
    console.log('Hello HttpProvider Provider');
  }
  getUsers(){
    return this.http1.get(this.path);
  }
  callPostRegistro(username, name, email, password)
  {
    //let url = 'http://localhost:9080/PacketTecServer/rest/register';
    let param = {username : username, name : name, email : email, password : password};
    //this.datos = {username : username, name : name, email : email, password : password};
    let request = this.http.post(this.path, param);
    return request.toPromise();
    
  }

  callPostLogin(username,password)
  {
    let url = 'http://localhost:9080/PacketTecServer/rest/register/login';
    let param = {username : username, password : password};
    let request = this.http.post(url , param);
    return request.toPromise();
    
  }
loadUsers(){
  return this.http
  .get(this.path)
  .map(res => res.json(),
      err => {
        console.log(err);
      }
    )
    .toPromise();


  }
  callGet(ussername, name, email, password)
  {
    let url = "http://localhost:9080/PacketTecServer/rest/register?ussername=" + ussername +"&name="+ name+"&email="+ email + "&password" + password;
    let request = this.http.get(url);
    return request.toPromise(); 
  }

}
