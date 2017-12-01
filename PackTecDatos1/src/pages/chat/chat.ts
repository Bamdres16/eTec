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
  nombres: any;

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
      this.nombres = this.usuarios;
      console.log(this.usuarios)
    },
    (error) =>{
      console.log(error);
    }
  )
 }
 public viewList(id){
  let vista = this.usuarios.filter(function(e,i){
    e.username == id})[0];
  let alert = this.alertCtrl.create({
    title: vista.name,
    subtitle: vista.email,
    buttons: ['OK']
  });
  alert.present();
 }
 Mostrar(nombre){
  viewList(nombre);
  this.navCtrl.push(MensajePage,{nombre: nombre.name});
  console.log( nombre.name.first);
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
