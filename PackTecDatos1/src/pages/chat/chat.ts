import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {HttpProvider} from '../../providers/http/http';
import {MensajePage } from '../mensaje/mensajes';

@Component({
  selector: 'page-chat',
  templateUrl: 'chat.html'
})
export class ChatPage {
  usuarios : any[]= [];
  constructor(public navCtrl: NavController, public navParams: NavParams,
    public http:HttpProvider, public userService: HttpProvider) {

  }
  CargarUsuarios(){
    this.http.getUsers().subscribe((data) =>{
      this.usuarios = data['results'];
      console.log(this.usuarios)
    },
    (error) =>{
      console.log(error);
    }
  )
 }
 Mostrar(nombre){
  this.navCtrl.push(MensajePage,{nombre: nombre.name.first});
  console.log( nombre.name.first);
}
}
