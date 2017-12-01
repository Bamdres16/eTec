import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import {HttpProvider} from '../../providers/http/http';
import {HttpClient} from '@angular/common/http';
import { UsernamelogProvider} from '../../providers/usernamelog/usernamelog';

@Component({
  selector: 'page-mensaje',
  templateUrl: 'mensaje.html'
})
export class MensajePage {
  destinatario: string;
  enviados: any[] = [];
  recibidos: any[] =[];
  destinatarios: any[] = [];
  mensaje:string = '';
  nombreDe: string = "";
  Json :string = '';
  found:boolean;
  constructor(public navCtrl: NavController, public http:HttpProvider, public userService:HttpProvider,  public http1:HttpClient, public navParams:NavParams,public userP: UsernamelogProvider) {
    this.setRemite();
    this.destinatario = this.navParams.get('nombre');
    this.found = false;
    this.CargarMensaje();
  }
  CargarMensaje(){
    //this.http1.get('http://localhost:9080/PacketTecServer/rest/message/?destinatario=${this.nombre}')
    this.http.getMessages()
    .subscribe(
      (data:any[]) =>{
        this.destinatarios = data["mensajes"];
          console.log("total de mensjaes: "+this.destinatarios)
          this.sethtml(this.destinatarios);
        

    },
    (error) =>{
      console.log(error);
    }
  )
  }
  sethtml(menssages){
    console.log(menssages.length)
    for(let i in menssages){
      console.log(i);
      if(menssages[i].destinatario === this.destinatario && menssages[i].remitente === this.nombreDe){
        //console.log(menssages[i]);
        this.enviados.push(menssages[i]);
        console.log("lista enviados: " + this.enviados);
      }else{
        //console.log(this.recibidos);
        if(menssages[i].destinatario === this.nombreDe && menssages[i].remitente === this.destinatario){
          //console.log(this.destinatarios[i]);
          this.recibidos.push(menssages[i]);
          console.log("lista recibidos: "+this.recibidos);
        }
      }
        }
  }
  setRemite(){
    this.nombreDe = this.userP.getUsername();
    console.log("remitente"+this.nombreDe);
  }
  EnviarMensaje(){
    if(this.mensaje.length){
      this.found = true;
    }
    console.log(this.mensaje);
  }
  PostS(){
    if(this.destinatario != null && this.nombreDe != null && this.mensaje != null){
    let h = this.http.postUsers(this.destinatario,this.mensaje,this.nombreDe);
    h.then(data =>{
      this.Json = data["_body"];
      console.log(data);
      console.log(this.Json);
    })
    //this.CargarMensaje();
  }
  }
}
