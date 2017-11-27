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
}