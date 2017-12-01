import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {HttpProvider} from '../../providers/http/http';
import {MensajePage } from '../mensaje/mensajes';
import { UsernamelogProvider} from '../../providers/usernamelog/usernamelog';

@Component({
  selector: 'page-chat',
  templateUrl: 'chat.html'
})
export class ChatPage {
  usuarios : any[]= [];
  remitente:string ="";
  searchQuery: string = '';
  nombres: any[] = [];

  constructor(public navCtrl: NavController, public navParams: NavParams,
    public http:HttpProvider, public userService: HttpProvider, public userP: UsernamelogProvider) {
     this.setRemitente();
     this.CargarUsuarios();
  }
  
  CargarUsuarios(){
    this.http.getUsers().subscribe((data) =>{
      this.usuarios = data['results'];
      for(let u in this.usuarios){
        if(this.usuarios[u].username !== this.remitente){
          this.nombres.push(this.usuarios[u]);
        }
      }
      
      console.log(this.usuarios)
    },
    (error) =>{
      console.log(error);
    }
  )
 }
 setRemitente(){
  this.remitente = this.userP.getUsername();
  console.log(this.remitente);
 }
 Mostrar(nombre){
  this.navCtrl.push(MensajePage,{nombre: nombre.name});
  console.log("destinatario" + nombre.name);
}
getItems(ev: any) {
  this.CargarUsuarios();
  
  console.log(this.nombres);
  let val = ev.target.value;
  if (val && val.trim() != '') {
    this.nombres = this.nombres.filter((usuaria) => {
      
        return (usuaria.name.toLowerCase().indexOf(val.toLowerCase()) > -1);
    })
  }
}
}
