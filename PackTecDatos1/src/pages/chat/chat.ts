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
  remitente:string ="";
  searchQuery: string = '';

  constructor(public navCtrl: NavController, public navParams: NavParams,
    public http:HttpProvider, public userService: HttpProvider) {
     this.CargarUsuarios();
  }
  CargarRemitente(nombreR){
    this.remitente = nombreR;
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
  this.navCtrl.push(MensajePage,{nombre: nombre.name});
  console.log( nombre.name.first);
}
getItems(ev: any) {
  this.CargarUsuarios();
  let val = ev.target.value;
  if (val && val.trim() != '') {
    this.usuarios = this.usuarios.filter((usuario) => {
      return (usuario.indexOf(val > -1));
    })
  }
}
}
