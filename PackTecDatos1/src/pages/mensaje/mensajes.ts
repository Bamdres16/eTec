import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {HttpProvider} from '../../providers/http/http';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'page-mensaje',
  templateUrl: 'mensaje.html'
})
export class MensajePage {
  nombre: string;
  putas: any[] = [];
  destinatarios: any[] = [];
  mensaje:string = '';
  nombreDe: string = "pepito";
  Json :string = '';
  found:boolean;
  constructor(public navCtrl: NavController, public http:HttpProvider, public userService:HttpProvider,  public http1:HttpClient, public navParams:NavParams) {
    this.nombre = this.navParams.get('nombre');
    this.found = false;
    if(this.putas.length != null){
      this.CargarMensaje();
    }
  }
  CargarMensaje(){
    //this.http1.get('http://localhost:9080/PacketTecServer/rest/message/?destinatario=${this.nombre}')
    this.http.getMessages(this.nombreDe)
    .subscribe(
      (data:any[]) =>{
        this.destinatarios = data["mensajes"];
        for(let i in this.destinatarios){
          console.log(i);
          if(this.destinatarios[i].destinatario === this.nombre){
            console.log(this.destinatarios[i]);
            this.putas.push(this.destinatarios[i]);
            console.log(this.putas);
          }
        }
        if(this.putas.length != null){
          console.log(this.putas);

        }

    },
    (error) =>{
      console.log(error);
    }
  )
  }
  EnviarMensaje(){
    if(this.mensaje.length){
      this.found = true;
    }
    console.log(this.mensaje);
  }
  PostS(){
    if(this.nombre != null && this.nombreDe != null && this.mensaje != null){
    let h = this.http.postUsers(this.nombre,this.mensaje,this.nombreDe);
    h.then(data =>{
      this.Json = data["_body"];
      console.log(data);
      console.log(this.Json);
    })
    //this.CargarMensaje();
  }
  }
}
